import java.util.HashMap;

/*
You are given an integer array nums and an integer k.
The frequency of an element x is the number of times it occurs in an array.
An array is called good if the frequency of each element in this array is less than or equal to k.
Return the length of the longest good subarray of nums.
A subarray is a contiguous non-empty sequence of elements within an array.
*/
public class LengthOfLongestSubarrayWithAtMostKFrequency2958 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
        System.out.println(maxSubarrayLength(nums, k));

        int[] nums2 = {1, 2, 1, 2, 1, 2, 1, 2, 1};
        int k2 = 2;
        System.out.println(maxSubarrayLength(nums2, k2));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        int max = 0;
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int left = 0, right = 0; right < nums.length; right++) {
            int frequency = frequencies.getOrDefault(nums[right], 0) + 1;
            frequencies.put(nums[right], frequency);
            while (frequency > k) {
                frequencies.put(nums[left], frequencies.get(nums[left]) - 1);
                if (nums[left] == nums[right]) frequency--;
                left++;
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}
