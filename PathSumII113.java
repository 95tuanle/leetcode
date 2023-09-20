import java.util.LinkedList;
import java.util.List;

/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
*/
public class PathSumII113 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println(pathSum(root2, 5));

        System.out.println(pathSum(null, 0));

        TreeNode root3 = new TreeNode(1);

        System.out.println(pathSum(root3, 1));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();
        depthFirstSearch(root, targetSum, new LinkedList<>(), result);
        return result;
    }

    public static void depthFirstSearch(TreeNode node, int targetSum, LinkedList<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;
        currentPath.addLast(node.val);
        targetSum -= node.val;
        if (node.left == null && node.right == null && targetSum == 0) {
            result.add(new LinkedList<>(currentPath));
        } else {
            depthFirstSearch(node.left, targetSum, currentPath, result);
            depthFirstSearch(node.right, targetSum, currentPath, result);
        }
        currentPath.removeLast();
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
