import java.util.Arrays;

/*
You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.
*/
public class MaxNumberOfKSumPairs1679 {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }

    public static int maxOperations(int[] nums, int k) {
        int numOfOperations = 0;
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                left++;
                right--;
                numOfOperations++;
            } else {
                if (k - nums[left] > nums[right]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return numOfOperations;
    }
}
