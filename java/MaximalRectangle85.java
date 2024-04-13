/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
*/
public class MaximalRectangle85 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));

        matrix = new char[][]{{'0', '1'}, {'1', '0'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        int[][] cache = new int[rows][columns];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    cache[i][j] = j == 0 ? 1 : cache[i][j - 1] + 1; // width of the rectangle ending at this point
                    for (int k = i, width = cache[i][j]; k >= 0; k--) {
                        width = Math.min(width, cache[k][j]); // find the minimum width from this row to the topmost row
                        max = Math.max(max, width * (i - k + 1)); // calculate the maximum area
                    }
                }
            }
        }
        return max;
    }
}
