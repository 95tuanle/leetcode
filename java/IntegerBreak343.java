package java;

/*
Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
Return the maximum product you can get.
*/
public class IntegerBreak343 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(8));
    }

    public static int integerBreak(int n) {
        double max = 0;
        for (int i = 2; i <= n; i++) {
            int math = n / i;
            if (n % i == 0) max = Math.max(max, Math.pow(math, i));
            else {
                int mod = n % i;
                if (mod == i - 1) max = Math.max(max, Math.pow(math + 1, i - 1) * math);
                else max = Math.max(max, Math.pow(math, i - 1) * (math + mod));
            }
        }
        return (int) max;
    }
}
