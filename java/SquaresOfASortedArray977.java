/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
*/
public class SquaresOfASortedArray977 {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = sortedSquares(nums);
        for (int i : result) System.out.print(i + " ");
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, index = nums.length - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare < rightSquare) {
                result[index--] = rightSquare;
                right--;
            } else {
                result[index--] = leftSquare;
                left++;
            }
        }
        return result;

//        for (int i = 0; i < nums.length; i++) nums[i] *= nums[i];
//        Arrays.sort(nums);
//        return nums;
    }
}
