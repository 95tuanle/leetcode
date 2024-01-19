import java.util.ArrayList;

/*
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
*/
public class NearestExitFromEntranceInMaze1926 {
    public static void main(String[] args) {
        char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance = {1, 2};
        System.out.println(nearestExit(maze, entrance));

        char[][] maze2 = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        int[] entrance2 = {1, 0};
        System.out.println(nearestExit(maze2, entrance2));

        char[][] maze3 = {{'.', '+'}};
        int[] entrance3 = {0, 0};
        System.out.println(nearestExit(maze3, entrance3));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        ArrayList<int[]> neighbors = new ArrayList<>();
        if (entrance[0] - 1 >= 0)
            if (maze[entrance[0] - 1][entrance[1]] == '.') neighbors.add(new int[]{entrance[0] - 1, entrance[1]});
        if (entrance[1] + 1 < maze[0].length)
            if (maze[entrance[0]][entrance[1] + 1] == '.') neighbors.add(new int[]{entrance[0], entrance[1] + 1});
        if (entrance[0] + 1 < maze.length)
            if (maze[entrance[0] + 1][entrance[1]] == '.') neighbors.add(new int[]{entrance[0] + 1, entrance[1]});
        if (entrance[1] - 1 >= 0)
            if (maze[entrance[0]][entrance[1] - 1] == '.') neighbors.add(new int[]{entrance[0], entrance[1] - 1});
        if (neighbors.isEmpty()) return -1;

        return 0;
    }

    private static ArrayList<int[]> findNeighbors(char[][] maze, int[] entrance) {
        ArrayList<int[]> neighbors = new ArrayList<>();

        return neighbors;
    }
}
