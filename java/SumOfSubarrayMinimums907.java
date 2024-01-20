import java.util.Arrays;
import java.util.Stack;

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
        Stack<Integer> stack = new Stack<>();
        int[] previousLesser = new int[arr.length];
        int[] nextLesserOrEqual = new int[arr.length];
        Arrays.fill(nextLesserOrEqual, arr.length);
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) nextLesserOrEqual[stack.pop()] = i;
            previousLesser[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        long sum = 0;
        double mod = Math.pow(10, 9) + 7;
        for (int i = 0; i < arr.length; i++) {
            sum += (long) (i - previousLesser[i]) * (nextLesserOrEqual[i] - i) * arr[i];
            sum %= (long) mod;
        }
        return (int) sum;
    }
}
