import java.util.*;

/*
There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
It's guaranteed that each city can reach city 0 after reorder.
*/
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero1466 {
    public static void main(String[] args) {
        System.out.println(minReorder(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}));
        System.out.println(minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
        System.out.println(minReorder(3, new int[][]{{1, 0}, {2, 0}}));
    }

    public static int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] connection : connections) {
            graph.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
            graph.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(-connection[0]);
        }
        Set<Integer> visited = new HashSet<>();
        return depthFirstSearch(0, graph, visited, 0);
    }

    private static int depthFirstSearch(int city, Map<Integer, List<Integer>> graph, Set<Integer> visited, int result) {
        visited.add(city);
        for (int neighbor : graph.getOrDefault(city, new ArrayList<>()))
            if (!visited.contains(Math.abs(neighbor))) {
                if (neighbor > 0) result++;
                result = depthFirstSearch(Math.abs(neighbor), graph, visited, result);
            }
        return result;
    }

//     public static int minReorder(int n, int[][] connections) {
//         Map<Integer, List<List<Integer>>> adj = new HashMap<>();
//         for (int[] connection : connections) {
//             adj.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(Arrays.asList(connection[1], 1));
//             adj.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(Arrays.asList(connection[0], 0));
//         }
//         return depthFirstSearch(0, -1, adj, 0);
//     }
//
//     public static int depthFirstSearch(int node, int parent, Map<Integer, List<List<Integer>>> adj, int count) {
//         if (!adj.containsKey(node)) return count;
//         for (List<Integer> neighbor : adj.get(node)) {
//             int child = neighbor.get(0);
//             int sign = neighbor.get(1);
//             if (child != parent) {
//                 count += sign;
//                 count = depthFirstSearch(child, node, adj, count);
//             }
//         }
//         return count;
//     }
}

class Solution {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    Set<String> connects = new HashSet<>();
    int rc = 0;

    public int minReorder(int n, int[][] connections) {
        for (int i = 0; i < n; i++)
            map.put(i, new HashSet<>());
        for (int[] c : connections) {
            connects.add(c[0] + " " + c[1]);
            map.get(c[0]).add(c[1]);
            map.get(c[1]).add(c[0]);
        }
        set.add(0);
        dfs(0);
        return rc;
    }

    void dfs(int i) {
        for (int neigh : map.get(i)) {
            if (set.contains(neigh)) continue;
            if (!connects.contains(neigh + " " + i))
                rc++;
            set.add(neigh);
            dfs(neigh);

        }
    }
}