
import java.util.Stack;

/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern in nums, otherwise, return false.
*/
public class OneThreeTwoPattern456 {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(find132pattern(new int[]{-1, 3, 2, 0}));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1; j >= 0; j--)
            if (nums[j] > min[j]) {
                while (!stack.empty() && stack.peek() <= min[j]) stack.pop();
                if (!stack.empty() && stack.peek() < nums[j]) return true;
                stack.push(nums[j]);
            }
        return false;

//        int minI = Integer.MAX_VALUE;
//        for (int j = 0; j < nums.length - 1; j++) {
//            minI = Math.min(minI, nums[j]);
//            for (int k = j + 1; k < nums.length; k++) {
//                if (minI < nums[k] && nums[k] < nums[j]) {
//                    return true;
//                }
//            }
//        }
//        return false;

//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] < nums[k] && nums[k] < nums[j]) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
    }
}
