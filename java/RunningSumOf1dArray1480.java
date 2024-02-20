/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.
*/
public class RunningSumOf1dArray1480 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = runningSum(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }

        int[] nums2 = {1, 1, 1, 1, 1};
        int[] result2 = runningSum(nums2);
        for (int i : result2) {
            System.out.print(i + " ");
        }
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        return nums;
    }
}
