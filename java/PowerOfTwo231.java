/*
Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2x.
*/
public class PowerOfTwo231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1)); // true
        System.out.println(isPowerOfTwo(16)); // true
        System.out.println(isPowerOfTwo(3)); // false
        System.out.println(isPowerOfTwo(4)); // true
        System.out.println(isPowerOfTwo(5)); // false
        System.out.println(isPowerOfTwo(536870912)); // false
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        double log = Math.log10(n) / Math.log10(2);
        return (int) log - log == 0;
//        return n > 0 && (n & (n - 1)) == 0;
    }
}
