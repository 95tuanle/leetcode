package java;

/*
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
*/
public class MinimumOperationsToReduceXToZero1658 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println(minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }

    public static int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) target += num;
        if (target == 0) return nums.length;
        int maxLength = 0;
        int currentSum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (left <= right && currentSum > target) {
                currentSum -= nums[left];
                left++;
            }
            if (currentSum == target) maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength == 0 ? -1 : nums.length - maxLength;
    }
}
