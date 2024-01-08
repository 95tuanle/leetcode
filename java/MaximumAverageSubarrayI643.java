package java;

/*
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
*/
public class MaximumAverageSubarrayI643 {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage(new int[]{5}, 1));
        System.out.println(findMaxAverage(new int[]{0, 1, 1, 3, 3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double tempSum = 0;
        for (int i = 0; i < k; i++) tempSum += nums[i];
        double maxSum = tempSum;
        for (int i = k; i < nums.length; i++) {
            tempSum += nums[i] - nums[i - k];
            maxSum = Math.max(tempSum, maxSum);
        }
        return maxSum / k;
    }
}
