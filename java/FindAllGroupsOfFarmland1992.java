import java.util.ArrayList;

/*
You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.
To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.
land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].
Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are no groups of farmland, return an empty array. You may return the answer in any order.
*/
public class FindAllGroupsOfFarmland1992 {
    public static void main(String[] args) {
        int[][] result = findFarmland(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}});
        for (int[] array : result) {
            for (int i : array) System.out.print(i + " ");
            System.out.println();
        }
        result = findFarmland(new int[][]{{1, 1}, {1, 1}});
        for (int[] array : result) {
            for (int i : array) System.out.print(i + " ");
            System.out.println();
        }
        result = findFarmland(new int[][]{{0}});
        for (int[] array : result) {
            for (int i : array) System.out.print(i + " ");
            System.out.println();
        }
    }

    public static int[][] findFarmland(int[][] land) {
        ArrayList<int[]> result = new ArrayList<>();
        int rows = land.length, columns = land[0].length;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                if (land[i][j] == 1) {
                    int x, y = j;
                    for (x = i; x < rows && land[x][j] == 1; x++)
                        for (y = j; y < columns && land[x][y] == 1; y++)
                            land[x][y] = 0;
                    result.add(new int[]{i, j, x - 1, y - 1});
                }
        return result.toArray(int[][]::new);
    }
}
