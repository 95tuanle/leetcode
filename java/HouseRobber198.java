/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/
public class HouseRobber198 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(rob(nums2));
    }

    public static int rob(int[] nums) {
        int first = 0, second = 0;
        for (int num : nums) {
            int temp = Math.max(first + num, second);
            first = second;
            second = temp;
        }
        return second;
    }
}
