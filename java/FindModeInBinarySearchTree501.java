import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
If the tree has more than one mode, return them in any order.
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
*/
public class FindModeInBinarySearchTree501 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
        int[] result = findMode(root);
        for (int i : result) {
            System.out.println(i);
        }

        TreeNode root2 = new TreeNode(0);
        int[] result2 = findMode(root2);
        for (int i : result2) {
            System.out.println(i);
        }
    }

    public static int[] findMode(TreeNode root) {
        Map<Integer, Integer> counter = new HashMap<>();
        depthFirstSearch(root, counter);
        int maxFreq = 0;
        for (int i : counter.keySet()) maxFreq = Math.max(maxFreq, counter.get(i));
        List<Integer> list = new ArrayList<>();
        for (int i : counter.keySet()) if (counter.get(i) == maxFreq) list.add(i);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; ++i) result[i] = list.get(i);
        return result;
    }

    private static void depthFirstSearch(TreeNode node, Map<Integer, Integer> counter) {
        if (node == null) return;
        counter.put(node.val, counter.getOrDefault(node.val, 0) + 1);
        depthFirstSearch(node.left, counter);
        depthFirstSearch(node.right, counter);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
