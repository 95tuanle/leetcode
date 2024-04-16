import java.util.ArrayDeque;

/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
*/
public class LargestRectangleInHistogram84 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));

        heights = new int[]{2, 4};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int largest = 0, length = heights.length;
        for (int i = 0; i < length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()])
                largest = Math.max(largest, heights[stack.pop()] * (i - 1 - stack.peek()));
            stack.push(i);
        }
        while (stack.peek() != -1) largest = Math.max(largest, heights[stack.pop()] * (length - 1 - stack.peek()));
        return largest;
    }
}
