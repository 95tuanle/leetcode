
/*
Given an m x n binary matrix mat, return the number of special positions in mat.
A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
*/
public class SpecialPositionsInABinaryMatrix1582 {
    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
        System.out.println(numSpecial(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(numSpecial(new int[][]{{0, 1, 1}, {1, 0, 1}, {0, 0, 1}}));
    }

    public static int numSpecial(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        int[] rowSum = new int[height];
        int[] colSum = new int[width];
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++) {
                rowSum[row] += mat[row][col];
                colSum[col] += mat[row][col];
            }
        int result = 0;
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                if (mat[row][col] == 1 && rowSum[row] == 1 && colSum[col] == 1) result++;
        return result;
    }
}
