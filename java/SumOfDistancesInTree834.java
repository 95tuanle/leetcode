import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
*/
public class SumOfDistancesInTree834 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}}))); // [8,12,6,10,10,10]
        System.out.println(Arrays.toString(sumOfDistancesInTree(1, new int[][]{}))); // [0]
        System.out.println(Arrays.toString(sumOfDistancesInTree(2, new int[][]{{1, 0}}))); // [1,1]
    }

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int[] result = new int[n], count = new int[n];
        depthFirstSearch(0, -1, graph, result, count);
        depthFirstSearch2(0, -1, graph, result, count, n);
        return result;
    }

    private static void depthFirstSearch(int root, int pre, HashMap<Integer, ArrayList<Integer>> graph, int[] result, int[] count) {
        for (int neighbor : graph.getOrDefault(root, new ArrayList<>())) {
            if (neighbor == pre) continue;
            depthFirstSearch(neighbor, root, graph, result, count);
            count[root] += count[neighbor];
            result[root] += result[neighbor] + count[neighbor];
        }
        count[root]++;
    }

    private static void depthFirstSearch2(int root, int pre, HashMap<Integer, ArrayList<Integer>> graph, int[] result, int[] count, int n) {
        for (int neighbor : graph.getOrDefault(root, new ArrayList<>())) {
            if (neighbor == pre) continue;
            result[neighbor] = result[root] - count[neighbor] + n - count[neighbor];
            depthFirstSearch2(neighbor, root, graph, result, count, n);
        }
    }
}
