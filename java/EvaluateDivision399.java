import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
Return the answers to all queries. If a single answer cannot be determined, return -1.0.
Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
*/
public class EvaluateDivision399 {
    public static void main(String[] args) {
        double[] result = calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")), new double[]{2.0, 3.0}, Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")));
        System.out.println(Arrays.toString(result));

        double[] result1 = calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"), Arrays.asList("bc", "cd")), new double[]{1.5, 2.5, 5.0}, Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("c", "b"), Arrays.asList("bc", "cd"), Arrays.asList("cd", "bc")));
        System.out.println(Arrays.toString(result1));

        double[] result2 = calcEquation(List.of(Arrays.asList("a", "b")), new double[]{0.5}, Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "a"), Arrays.asList("a", "c"), Arrays.asList("x", "y")));
        System.out.println(Arrays.toString(result2));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            adj.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            adj.putIfAbsent(equations.get(i).get(1), new HashMap<>());
            adj.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            adj.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++)
            result[i] = breadthFirstSearch(queries.get(i).get(0), queries.get(i).get(1), adj);
        return result;
    }

    private static double breadthFirstSearch(String source, String target, HashMap<String, HashMap<String, Double>> adj) {
        if (!adj.containsKey(source) || !adj.containsKey(target)) return -1.0;
        if (source.equals(target)) return 1.0;
        LinkedList<String> queue = new LinkedList<>();
        HashMap<String, Double> visited = new HashMap<>();
        queue.add(source);
        visited.put(source, 1.0);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(target)) return visited.get(current);
            for (String neighbor : adj.get(current).keySet())
                if (!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    visited.put(neighbor, visited.get(current) * adj.get(current).get(neighbor));
                }
        }
        return -1.0;
    }
}
