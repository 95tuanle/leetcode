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
        int maxArea = 0, length = matrix[0].length;
        int[] heights = new int[length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (char[] row : matrix) {
            for (int i = 0; i < length; i++) {
                if (row[i] == '1') heights[i] += 1;
                else heights[i] = 0;
                while (stack.peek() != -1 && heights[i] <= heights[stack.peek()])
                    maxArea = Math.max(maxArea, heights[stack.pop()] * (i - 1 - stack.peek()));
                stack.push(i);
            }
            while (stack.peek() != -1) maxArea = Math.max(maxArea, heights[stack.pop()] * (length - 1 - stack.peek()));
        }
        return maxArea;
    }
}
