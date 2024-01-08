
import java.util.Arrays;

/*
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.
*/
public class SortArrayByParity905 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0})));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int evenIndex = 0;
        int oddIndex = nums.length - 1;
        while (evenIndex < oddIndex) {
            if (nums[evenIndex] % 2 == 0) evenIndex++;
            else {
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex--] = temp;
            }
        }
        return nums;
//        int[] result = new int[nums.length];
//        int evenIndex = 0;
//        int oddIndex = nums.length - 1;
//        for (int num : nums) {
//            if (num % 2 == 0) result[evenIndex++] = num;
//            else result[oddIndex--] = num;
//        }
//        return result;
    }
}
