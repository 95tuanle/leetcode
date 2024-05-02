/*
Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
Return the positive integer k. If there is no such integer, return -1.
*/
public class LargestPositiveIntegerThatExistsWithItsNegative2441 {
    public static void main(String[] args) {
        int[] nums = {3, 2, -2, 5, -3};
        System.out.println(findMaxK(nums));

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(findMaxK(nums2));
    }

    public static int findMaxK(int[] nums) {
        int max = -1;
        int[] array = new int[1001];
        for (int num : nums) {
            int index = Math.abs(num);
            if (array[index] != num) array[index] += num;
            if (array[index] == 0) max = Math.max(max, index);
        }
        return max;

//        Arrays.sort(nums);
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            if (nums[left] == -nums[right]) return nums[right];
//            if (nums[left] < -nums[right]) left++;
//            else right--;
//        }
//        return -1;
    }
}
