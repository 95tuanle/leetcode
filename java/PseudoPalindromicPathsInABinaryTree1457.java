/*
Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
*/
public class PseudoPalindromicPathsInABinaryTree1457 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(pseudoPalindromicPaths(root));

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.left.right.right = new TreeNode(1);
        System.out.println(pseudoPalindromicPaths(root2));
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int i) {
        if (root == null) return 0;
        i ^= 1 << (root.val - 1);
        int res = dfs(root.left, i) + dfs(root.right, i);
        if (root.left == root.right && (i & (i - 1)) == 0) res++;
        return res;
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


