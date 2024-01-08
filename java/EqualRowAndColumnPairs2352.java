import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
*/
public class EqualRowAndColumnPairs2352 {
    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{{1, 2, 3}, {3, 2, 1}, {2, 1, 3}}));
        System.out.println(equalPairs(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
        System.out.println(equalPairs(new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}));
        System.out.println(equalPairs(new int[][]{{1, 2, 3}, {3, 2, 1}, {2, 1, 3}}));
    }

    public static int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;
        Map<String, Integer> rows = new HashMap<>();
        for (int[] row : grid) {
            String string = Arrays.toString(row);
            rows.put(string, rows.getOrDefault(string, 0) + 1);
        }
        for (int c = 0; c < n; c++) {
            int[] column = new int[n];
            for (int r = 0; r < n; r++) column[r] = grid[r][c];
            count += rows.getOrDefault(Arrays.toString(column), 0);
        }
        return count;
    }
}
