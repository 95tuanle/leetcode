/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/
public class SameTree100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree(p, q));

        p = new TreeNode(1, new TreeNode(2), null);
        q = new TreeNode(1, null, new TreeNode(2));
        System.out.println(isSameTree(p, q));

        p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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


