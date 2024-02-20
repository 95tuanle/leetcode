/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
*/
public class MissingNumber268 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1})); // 2
        System.out.println(missingNumber(new int[]{0, 1})); // 2
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})); // 8
        System.out.println(missingNumber(new int[]{0})); // 1
    }

    public static int missingNumber(int[] nums) {
//        int n = nums.length;
//        int sum = n * (n + 1) / 2;
//        for (int num : nums) {
//            sum -= num;
//        }
//        return sum;

        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            sum += i;
        }
        return sum;
    }
}
