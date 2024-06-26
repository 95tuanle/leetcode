/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
*/
public class IslandPerimeter463 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));

        int[][] grid2 = {{1}};
        System.out.println(islandPerimeter(grid2));

        int[][] grid3 = {{1, 0}};
        System.out.println(islandPerimeter(grid3));

        int[][] grid4 = {{1, 1}, {1, 1}};
        System.out.println(islandPerimeter(grid4));
    }

    public static int islandPerimeter(int[][] grid) {
        int rows = grid.length, columns = grid[0].length, result = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) result++;
                    if (j == 0 || grid[i][j - 1] == 0) result++;
                    if (i == rows - 1 || grid[i + 1][j] == 0) result++;
                    if (j == columns - 1 || grid[i][j + 1] == 0) result++;
                }
        return result;
    }
}
