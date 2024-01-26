/*
There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
*/
public class OutOfBoundaryPaths576 {
    public static void main(String[] args) {
        System.out.println(findPaths(2, 2, 2, 0, 0));
        System.out.println(findPaths(1, 3, 3, 0, 1));
        System.out.println(findPaths(8, 7, 16, 1, 5));
        System.out.println(findPaths(36, 5, 50, 15, 3));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (startRow == m || startColumn == n || startRow < 0 || startColumn < 0) return 1;
        if (maxMove == 0) return 0;
        return findPaths(m, n, maxMove - 1, startRow - 1, startColumn) + findPaths(m, n, maxMove - 1, startRow + 1, startColumn) + findPaths(m, n, maxMove - 1, startRow, startColumn - 1) + findPaths(m, n, maxMove - 1, startRow, startColumn + 1);
    }
}
