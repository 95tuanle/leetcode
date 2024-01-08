package java;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
*/
public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{1, 2, 4, 3}));
        System.out.println(maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}));
        System.out.println(maxArea(new int[]{6, 4, 3, 1, 4, 6, 99, 62, 1, 2, 6}));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = (right - left) * currentHeight;
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;

//        int maxArea = 0;
//        int left = 0;
//        int right = height.length - 1;
//        while (left < right) {
//            int currentHeight = Math.min(height[left], height[right]);
//            int currentArea = (right - left) * currentHeight;
//            if (maxArea < currentArea) {
//                maxArea = currentArea;
//            }
//            int newLeft = left;
//            int newRight = right;
//            if (height[newLeft] > height[newRight]) {
//                newRight--;
//            } else if (height[newLeft] < height[newRight]) {
//                newLeft++;
//            } else {
//                if (height[newRight] < height[newRight - 1]) {
//                    newRight--;
//                }
//                if (height[newLeft] < height[newLeft + 1]) {
//                    newLeft++;
//                }
//            }
//            if (newLeft == left && newRight == right) {
//                right--;
//                left++;
//            } else {
//                left = newLeft;
//                right = newRight;
//            }
//        }
//        return maxArea;
    }
}
