/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
*/
public class FirstMissingPositive41 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositive(new int[]{3, 3, 1, 4, 0}));
    }

    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) if (nums[i] < 0) nums[i] = 0;
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (index >= 0 && index < length) {
                if (nums[index] > 0) nums[index] *= -1;
                else if (nums[index] == 0) nums[index] = -(length + 1);
            }
        }
        for (int i = 0; i < length; i++) if (nums[i] >= 0) return i + 1;
        return length + 1;
    }
}
