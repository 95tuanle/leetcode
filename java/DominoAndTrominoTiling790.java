/*
You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.
In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.
*/
public class DominoAndTrominoTiling790 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTilings(n));

        n = 4;
        System.out.println(numTilings(n));

        n = 5;
        System.out.println(numTilings(n));
    }

    public static int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        long long1 = 1, long2 = 2, long3 = 5, temp;
        for (int i = 4; i <= n; ++i) {
            temp = (2 * long3 + long1) % 1000000007;
            long1 = long2;
            long2 = long3;
            long3 = temp;
        }
        return (int) long3;

//        long[] g = new long[1001], u = new long[1001];
//        final int mod = 1000000007;
//        g[0] = 0;
//        g[1] = 1;
//        g[2] = 2;
//        u[0] = 0;
//        u[1] = 1;
//        u[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            u[i] = (u[i - 1] + g[i - 1]) % mod;
//            g[i] = (g[i - 1] + g[i - 2] + 2 * u[i - 2]) % mod;
//        }
//        return (int) g[n] % mod;
    }
}
