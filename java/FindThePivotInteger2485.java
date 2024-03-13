/*
Given a positive integer n, find the pivot integer x such that:
The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.
*/
public class FindThePivotInteger2485 {
    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
        System.out.println(pivotInteger(1));
        System.out.println(pivotInteger(4));
    }

    public static int pivotInteger(int n) {
        int sum1 = n * (n + 1) / 2;
        int sum2 = 0;
        for (int i = 1; i <= n; i++) {
            sum2 += i;
            sum1 -= i;
            if (sum2 == sum1) return i;
            else if (sum2 > sum1) break;
        }
        return -1;

//        int sum1 = 0;
//        for (int i = 1; i <= n; i++) sum1 += i;
//        int sum2 = 0;
//        for (int i = 1; i <= n; i++) {
//            sum2 += i;
//            sum1 -= i - 1;
//            if (sum1 == sum2) return i;
//            else if (sum1 < sum2) break;
//        }
//        return -1;
    }
}
