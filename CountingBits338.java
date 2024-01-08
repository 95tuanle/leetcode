import java.util.Arrays;

/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
*/
public class CountingBits338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] integers = new int[n + 1];
        for (int i = 0; i <= n; i++) integers[i] = Integer.bitCount(i);
        return integers;
    }
}
