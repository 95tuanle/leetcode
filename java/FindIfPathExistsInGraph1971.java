import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/*
There is a bidirectional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
You want to determine if there is a valid path that exists from vertex source to vertex destination.
Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
*/
public class FindIfPathExistsInGraph1971 {
    public static void main(String[] args) {
        System.out.println(validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2)); // true
        System.out.println(validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5)); // false
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (node == destination) return true;
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>()))
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
        }
        return false;

//        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
//        for (int[] edge : edges) {
//            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
//            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
//        }
//        boolean[] visited = new boolean[n];
//        return depthFirstSearch(source, destination, graph, visited);
//    }
//
//    private static boolean depthFirstSearch(int source, int destination, HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited) {
//        if (source == destination) return true;
//        visited[source] = true;
//        for (int neighbor : graph.getOrDefault(source, new ArrayList<>()))
//            if (!visited[neighbor] && depthFirstSearch(neighbor, destination, graph, visited)) return true;
//        return false;
    }
}
