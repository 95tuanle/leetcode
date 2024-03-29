/*
You are given an integer array nums and a positive integer k.
Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
A subarray is a contiguous sequence of elements within an array.
*/
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes2962 {
    public static void main(String[] args) {
        System.out.println(new CountSubarraysWhereMaxElementAppearsAtLeastKTimes2962().countSubarrays(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(new CountSubarraysWhereMaxElementAppearsAtLeastKTimes2962().countSubarrays(new int[]{1, 4, 2, 3}, 2));
        System.out.println(new CountSubarraysWhereMaxElementAppearsAtLeastKTimes2962().countSubarrays(new int[]{2, 1, 2, 1, 2}, 2));
    }

    public long countSubarrays(int[] nums, int k) {
        long result = 0;
        int max = 1, counter = 0, left = 0, right = 0;
        for (int num : nums) max = Math.max(num, max);
        for (; right < nums.length; right++) {
            if (nums[right] == max) counter++;
            while (counter == k) if (nums[left++] == max) counter--;
            result += left;
        }
        return result;
    }
}
