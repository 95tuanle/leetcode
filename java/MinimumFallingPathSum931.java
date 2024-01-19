/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
*/
public class MinimumFallingPathSum931 {
    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(matrix));

        int[][] matrix2 = {{-19, 57}, {-40, -5}};
        System.out.println(minFallingPathSum(matrix2));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][0];
            for (int j = 1; j < n - 1; j++)
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + matrix[i][j];
            dp[i][n - 1] = Math.min(dp[i - 1][n - 2], dp[i - 1][n - 1]) + matrix[i][n - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) min = Math.min(min, dp[n - 1][i]);
        return min;

//        int n = matrix.length;
//        int[][] dp = new int[n][n];
//        System.arraycopy(matrix[0], 0, dp[0], 0, n);
//        for (int i = 1; i < n; i++)
//            for (int j = 0; j < n; j++)
//                if (j == 0) dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
//                else if (j == n - 1) dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
//                else dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j + 1], dp[i - 1][j - 1]));
//        int min = dp[n - 1][0];
//        for (int num : dp[n - 1]) min = Math.min(min, num);
//        return min;
    }
}
