import java.util.LinkedList;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/
public class NumberOfIslands200 {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println(numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }

    public static int numIslands(char[][] grid) {
        int result = 0, rows = grid.length, columns = grid[0].length;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                if (grid[i][j] == '1') {
                    result++;
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int[] target = queue.remove();
                        if (target[0] != 0 && grid[target[0] - 1][target[1]] == '1') {
                            queue.add(new int[]{target[0] - 1, target[1]});
                            grid[target[0] - 1][target[1]] = '0';
                        }
                        if (target[1] != 0 && grid[target[0]][target[1] - 1] == '1') {
                            queue.add(new int[]{target[0], target[1] - 1});
                            grid[target[0]][target[1] - 1] = '0';
                        }
                        if (target[0] != rows - 1 && grid[target[0] + 1][target[1]] == '1') {
                            queue.add(new int[]{target[0] + 1, target[1]});
                            grid[target[0] + 1][target[1]] = '0';
                        }
                        if (target[1] != columns - 1 && grid[target[0]][target[1] + 1] == '1') {
                            queue.add(new int[]{target[0], target[1] + 1});
                            grid[target[0]][target[1] + 1] = '0';
                        }
                    }
                }
        return result;
    }
}
