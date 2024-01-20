/*
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
*/
public class SumOfSubarrayMinimums907 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));

        int[] arr2 = {11, 81, 94, 43, 3};
        System.out.println(sumSubarrayMins(arr2));
    }

    public static int sumSubarrayMins(int[] arr) {
        return 0;
    }
}
