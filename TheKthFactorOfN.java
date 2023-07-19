/*
You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.
*/
import java.util.ArrayList;

public class TheKthFactorOfN {
    public static void main(String[] args) {
        System.out.println(kthFactor(12, 3));
        System.out.println(kthFactor(7, 2));
        System.out.println(kthFactor(4, 4));
    }

    public static int kthFactor(int n, int k) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) factors.add(i);
            if (factors.size() == k) return factors.get(k - 1);
        }
        if (factors.size() < k) return -1;
        return factors.get(k - 1);
    }
}
