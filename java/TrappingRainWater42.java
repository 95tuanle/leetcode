/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/
public class TrappingRainWater42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height2));
    }

    public static int trap(int[] height) {
        int result = 0, left = 0, leftMax = 0, right = height.length - 1, rightMax = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) leftMax = height[left++];
                else result += leftMax - height[left++];
            } else {
                if (height[right] >= rightMax) rightMax = height[right--];
                else result += rightMax - height[right--];
            }
        }
        return result;
    }
}
