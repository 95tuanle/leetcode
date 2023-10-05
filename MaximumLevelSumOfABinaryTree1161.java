/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
*/
public class MaximumLevelSumOfABinaryTree1161 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
        System.out.println(maxLevelSum(root));

        TreeNode root2 = new TreeNode(989, null, new TreeNode(10250, new TreeNode(98693), null));
        System.out.println(maxLevelSum(root2));
    }

    public static int maxLevelSum(TreeNode root) {
        return 0;
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
