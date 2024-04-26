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
        int n = grid.length, smallestSum = 0, smallestPreviousIndex = -1, secondSmallestSum = 0;
        for (int[] row : grid) {
            int smallest = 100 + smallestSum, smallestIndex = -1, secondSmallest = 100 + secondSmallestSum;
            for (int i = 0; i < n; i++) {
                int value;
                if (i != smallestPreviousIndex) value = row[i] + smallestSum;
                else value = row[i] + secondSmallestSum;
                if (value <= smallest) {
                    secondSmallest = smallest;
                    smallest = value;
                    smallestIndex = i;
                } else if (value <= secondSmallest) secondSmallest = value;
            }
            smallestSum = smallest;
            smallestPreviousIndex = smallestIndex;
            secondSmallestSum = secondSmallest;
        }
        return smallestSum;

//        int n = grid.length, smallestSum = 0, smallestPreviousIndex = -1, secondSmallestSum = 0;
//        for (int[] row : grid) {
//            int smallest = 100, smallestIndex = -1, secondSmallest = 100, secondSmallestIndex = -1;
//            for (int j = 0; j < n; j++)
//                if (smallest > row[j]) {
//                    secondSmallest = smallest;
//                    secondSmallestIndex = smallestIndex;
//                    smallest = row[j];
//                    smallestIndex = j;
//                } else if (secondSmallest > row[j]) {
//                    secondSmallest = row[j];
//                    secondSmallestIndex = j;
//                }
//            if (smallestIndex != smallestPreviousIndex) smallest += smallestSum;
//            else smallest += secondSmallestSum;
//            if (secondSmallestIndex != smallestPreviousIndex) secondSmallest += smallestSum;
//            else secondSmallest += secondSmallestSum;
//            if (smallest > secondSmallest) {
//                smallestSum = secondSmallest;
//                smallestPreviousIndex = secondSmallestIndex;
//                secondSmallestSum = smallest;
//            } else {
//                smallestSum = smallest;
//                smallestPreviousIndex = smallestIndex;
//                secondSmallestSum = secondSmallest;
//            }
//        }
//        return smallestSum;
    }
}
