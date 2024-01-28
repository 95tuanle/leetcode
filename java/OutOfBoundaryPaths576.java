/*
There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
*/
public class OutOfBoundaryPaths576 {
    public static void main(String[] args) {
        System.out.println(findPaths(2, 2, 2, 0, 0));
        System.out.println(findPaths(1, 3, 3, 0, 1));
        System.out.println(findPaths(8, 7, 16, 1, 5));
        System.out.println(findPaths(36, 5, 50, 15, 3));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int M = 1000000000 + 7;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int count = 0;
        for (int moves = 1; moves <= maxMove; moves++) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    if (i == m - 1) count = (count + dp[i][j]) % M;
                    if (j == n - 1) count = (count + dp[i][j]) % M;
                    if (i == 0) count = (count + dp[i][j]) % M;
                    if (j == 0) count = (count + dp[i][j]) % M;
                    temp[i][j] = (((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M + ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % M) % M;
                }
            dp = temp;
        }
        return count;

//        return depthFirstSearch(m, n, maxMove, startRow, startColumn, new int[m][n][maxMove + 1]);
    }

//    public static int depthFirstSearch(int m, int n, int maxMove, int startRow, int startColumn, int[][][] dp) {
//        if (startRow == m || startColumn == n || startRow < 0 || startColumn < 0) return 1;
//        if (maxMove == 0) return 0;
//        if (dp[startRow][startColumn][maxMove] != 0) return dp[startRow][startColumn][maxMove];
//        dp[startRow][startColumn][maxMove] = ((depthFirstSearch(m, n, maxMove - 1, startRow - 1, startColumn, dp) + depthFirstSearch(m, n, maxMove - 1, startRow + 1, startColumn, dp)) % 1000000007 + ((depthFirstSearch(m, n, maxMove - 1, startRow, startColumn - 1, dp) + depthFirstSearch(m, n, maxMove - 1, startRow, startColumn + 1, dp)) % 1000000007)) % 1000000007;
//        return dp[startRow][startColumn][maxMove];
//    }
}
