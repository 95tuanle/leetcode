package java;

/*
You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
*/
public class SearchInABinarySearchTree700 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        TreeNode result = searchBST(root, 2);
        assert result != null;
        System.out.println(result.val);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);

//        if (root == null) return null;
//        if (root.val == val) return root;
//        TreeNode left = searchBST(root.left, val);
//        TreeNode right = searchBST(root.right, val);
//        return left == null ? right : left;
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
