
import java.util.Arrays;

/*
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
A row i is weaker than a row j if one of the following is true:
The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
*/
public class TheKWeakestRowsInAMatrix1337 {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int k = 3;
        int[] result = kWeakestRows(mat, k);
        for (int j : result) System.out.print(j + ' ');

        System.out.println();

        int[][] mat2 = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int k2 = 2;
        int[] result2 = kWeakestRows(mat2, k2);
        for (int j : result2) System.out.print(j + ' ');
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[][] rowStrengths = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int strength = 0;
            for (int j : mat[i]) {
                if (j == 0) break;
                strength++;
            }
            rowStrengths[i][0] = strength;
            rowStrengths[i][1] = i;
        }
        Arrays.sort(rowStrengths, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = rowStrengths[i][1];
        return result;
    }
}
