/*
The Tribonacci sequence Tn is defined as follows:
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.
*/
public class NthTribonacciNumber1137 {
    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int a = 0, b = 1, c = 1, temp;
        for (int i = 3; i <= n; i++) {
            temp = c;
            c += a + b;
            a = b;
            b = temp;
        }
        return c;

//        if (n == 0) return 0;
//        if (n == 1 || n == 2) return 1;
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 1;
//        for (int i = 3; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
//        }
//        return dp[n];

//        int a = 0, b = 1, c = 1;
//        for (int i = 3; i <= n + 2; i++) {
//            c += b + a;
//            int temp = b;
//            b = c - a - b;
//            a = temp;
//        }
//        return a;
    }
}
