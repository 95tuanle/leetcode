/*
You are given the root of a binary tree.
A ZigZag path for a binary tree is defined as follow:
Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
Return the longest ZigZag path contained in that tree.
*/
public class LongestZigZagPathInABinaryTree1372 {
    public static void main(String[] args) {
        System.out.println(longestZigZag(new TreeNode(1, null, new TreeNode(1, new TreeNode(1, new TreeNode(1, null, new TreeNode(1)), null), null))));
        System.out.println(longestZigZag(new TreeNode(1, new TreeNode(1, new TreeNode(1, null, new TreeNode(1)), null), null)));
        System.out.println(longestZigZag(new TreeNode(1)));
    }

    public static int longestZigZag(TreeNode root) {
        return solve(root, true, -1);
    }

    private static int solve(TreeNode root, boolean goLeft, int count) {
        if (root == null) return count;
        count++;
        if (goLeft) return Math.max(solve(root.left, false, count), solve(root.right, true, 0));
        else return Math.max(solve(root.left, false, 0), solve(root.right, true, count));
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
