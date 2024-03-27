/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
*/
public class SubarrayProductLessThanK713 {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));

        int[] nums2 = {1, 2, 3};
        int k2 = 0;
        System.out.println(numSubarrayProductLessThanK(nums2, k2));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int counter = 0;
        if (nums.length == 0) return counter;
        int product = 1, left = 0, right = 0;
        for (; right < nums.length; right++) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            counter += right - left + 1;
        }
        return counter;
    }
}
