/*
You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.
In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
Return the minimum number of moves required to make every node have exactly one coin.
*/
public class DistributeCoinsInBinaryTree979 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        System.out.println(distributeCoins(root));
    }

    public static int distributeCoins(TreeNode root) {
        return depthFirstSearch(root)[0];
    }

    private static int[] depthFirstSearch(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = depthFirstSearch(node.left);
        int[] right = depthFirstSearch(node.right);
        int available = node.val - 1 + left[1] + right[1];
        return new int[]{left[0] + right[0] + Math.abs(available), available};
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
