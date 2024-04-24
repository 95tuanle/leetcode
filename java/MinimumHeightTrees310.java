import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
Return a list of all MHTs' root labels. You can return the answer in any order.
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
*/
public class MinimumHeightTrees310 {
    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}})); // [1]
        System.out.println(findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}})); // [3, 4]
        System.out.println(findMinHeightTrees(1, new int[][]{})); // [0]
        System.out.println(findMinHeightTrees(2, new int[][]{{0, 1}})); // [0, 1]
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> leaves = new ArrayList<>();
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }
        ArrayList<LinkedList<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new LinkedList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++)
            if (adj.get(i).size() == 1) leaves.add(i);
        while (n > 2) {
            n -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int j = adj.get(leaf).getFirst();
                adj.get(j).removeFirstOccurrence(leaf);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
