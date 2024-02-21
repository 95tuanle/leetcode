/*
You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/

import java.util.ArrayList;

public class RottingOranges994 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));

        int[][] grid2 = new int[][]{{1, 2}};
        System.out.println(orangesRotting(grid2));
    }

    public static int orangesRotting(int[][] grid) {
        ArrayList<int[]> rottenOranges = new ArrayList<>();
        int freshOrangeCounter = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 2) rottenOranges.add(new int[]{i, j});
                else if (grid[i][j] == 1) freshOrangeCounter++;
        if (freshOrangeCounter == 0) return 0;
        if (rottenOranges.isEmpty()) return -1;
        return breathFirstSearch(grid, rottenOranges, 0, freshOrangeCounter, m, n);
    }

    private static int breathFirstSearch(int[][] grid, ArrayList<int[]> rottenOranges, int minutes, int freshOrangeCounter, int m, int n) {
        ArrayList<int[]> newRottenOranges = new ArrayList<>();
        for (int[] rottenOrange : rottenOranges) {
            if (rottenOrange[0] + 1 < m) if (grid[rottenOrange[0] + 1][rottenOrange[1]] == 1) {
                freshOrangeCounter--;
                grid[rottenOrange[0] + 1][rottenOrange[1]] = 2;
                newRottenOranges.add(new int[]{rottenOrange[0] + 1, rottenOrange[1]});
            }
            if (rottenOrange[0] - 1 >= 0) if (grid[rottenOrange[0] - 1][rottenOrange[1]] == 1) {
                freshOrangeCounter--;
                grid[rottenOrange[0] - 1][rottenOrange[1]] = 2;
                newRottenOranges.add(new int[]{rottenOrange[0] - 1, rottenOrange[1]});
            }
            if (rottenOrange[1] + 1 < n) if (grid[rottenOrange[0]][rottenOrange[1] + 1] == 1) {
                freshOrangeCounter--;
                grid[rottenOrange[0]][rottenOrange[1] + 1] = 2;
                newRottenOranges.add(new int[]{rottenOrange[0], rottenOrange[1] + 1});
            }
            if (rottenOrange[1] - 1 >= 0) if (grid[rottenOrange[0]][rottenOrange[1] - 1] == 1) {
                freshOrangeCounter--;
                grid[rottenOrange[0]][rottenOrange[1] - 1] = 2;
                newRottenOranges.add(new int[]{rottenOrange[0], rottenOrange[1] - 1});
            }
        }
        if (newRottenOranges.isEmpty()) {
            if (freshOrangeCounter == 0) return minutes;
            return -1;
        }
        return breathFirstSearch(grid, newRottenOranges, minutes + 1, freshOrangeCounter, m, n);
    }
}
