/*
Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.
*/
public class MinimumFallingPathSumII {
    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})); // 13
        System.out.println(minFallingPathSum(new int[][]{{7}})); // 7
        System.out.println(minFallingPathSum(new int[][]{{-73, 61, 43, -48, -36}, {3, 30, 27, 57, 10}, {96, -76, 84, 59, -15}, {5, -49, 76, 31, -7}, {97, 91, 61, -46, 67}})); // -192
        System.out.println(minFallingPathSum(new int[][]{{1, 99, 99}, {0, 2, 1}, {99, 99, 4}})); // 7
    }

    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length, smallest = 0, smallestIndex = -1, secondSmallest = 0;
        for (int[] row : grid) {
            int currentSmallest = 100 + smallest, currentSmallestIndex = -1, currentSecondSmallest = 100 + secondSmallest;
            for (int i = 0; i < n; i++) {
                int value = row[i];
                if (i != smallestIndex) value += smallest;
                else value += secondSmallest;
                if (value < currentSmallest) {
                    currentSecondSmallest = currentSmallest;
                    currentSmallest = value;
                    currentSmallestIndex = i;
                } else if (value < currentSecondSmallest) currentSecondSmallest = value;
            }
            smallest = currentSmallest;
            smallestIndex = currentSmallestIndex;
            secondSmallest = currentSecondSmallest;
        }
        return smallest;
    }
}
