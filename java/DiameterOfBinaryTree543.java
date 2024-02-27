/*
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
*/
public class DiameterOfBinaryTree543 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(diameterOfBinaryTree(root));

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(diameterOfBinaryTree(root));

        root = new TreeNode(1);
        System.out.println(diameterOfBinaryTree(root));

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null), null);
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        return depthFirstSearch(root)[1];
    }

    public static int[] depthFirstSearch(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = depthFirstSearch(root.left);
        int[] right = depthFirstSearch(root.right);
        int depth = Math.max(left[0], right[0]) + 1;
        int diameter = Math.max(Math.max(left[1], right[1]), left[0] + right[0]);
        return new int[]{depth, diameter};
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


