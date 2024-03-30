import java.util.HashMap;

/*
Given an integer array nums and an integer k, return the number of good subarrays of nums.
A good array is an array where the number of different integers in that array is exactly k.
For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.
*/
public class SubarraysWithKDifferentIntegers992 {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 3));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int result = 0, near = 0, far = 0;
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
            while (frequencies.size() > k) {
                int frequency = frequencies.get(nums[near]) - 1;
                if (frequency == 0) frequencies.remove(nums[near++]);
                else frequencies.replace(nums[near++], frequency);
                far = near;
            }
            while (frequencies.get(nums[near]) > 1) {
                frequencies.put(nums[near], frequencies.get(nums[near]) - 1);
                near++;
            }
            if (frequencies.size() == k) result += near - far + 1;
        }
        return result;
    }
}
