/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.
*/
public class NumberOfProvinces547 {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    public static int findCircleNum(int[][] isConnected) {
        int numberOfProvinces = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++)
            if (!visited[i]) {
                numberOfProvinces++;
                depthFirstSearch(i, isConnected, visited);
            }
        return numberOfProvinces;
    }

    private static void depthFirstSearch(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++)
            if (isConnected[node][i] == 1 && !visited[i]) depthFirstSearch(i, isConnected, visited);
    }
}
