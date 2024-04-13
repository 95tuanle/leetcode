import java.util.ArrayDeque;

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
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++)
                if (chars[j] == '1') heights[j] += 1;
                else heights[j] = 0;
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;

//        int maxArea = 0;
//        int[][] dp = new int[matrix.length][matrix[0].length];
//        for (int i = 0; i < matrix.length; i++)
//            for (int j = 0; j < matrix[0].length; j++)
//                if (matrix[i][j] == '1') {
//                    dp[i][j] = (j == 0) ? 1 : dp[i][j - 1] + 1;
//                    int width = dp[i][j];
//                    for (int k = i; k >= 0; k--) {
//                        width = Math.min(width, dp[k][j]);
//                        maxArea = Math.max(maxArea, width * (i - k + 1));
//                    }
//                }
//        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxArea;
    }
}
