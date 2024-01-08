package java;

/*
An array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise.
*/
public class MonotonicArray896 {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(isMonotonic(new int[]{1, 3, 2}));
    }

    public static boolean isMonotonic(int[] nums) {
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] > nums[i + 1]) {
                if (isIncreasing) return false;
                isDecreasing = true;
            } else if (nums[i] < nums[i + 1]) {
                if (isDecreasing) return false;
                isIncreasing = true;
            }
        return true;
    }
}
