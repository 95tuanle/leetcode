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
        return dfs(root, new int[10], 0);
//        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int[] freq, int oddCount) {
        if (node == null) return 0;
        freq[node.val]++;
        if (freq[node.val] % 2 == 1) oddCount++;
        else oddCount--;
        int res;
        if (node.left == null && node.right == null) res = oddCount <= 1 ? 1 : 0;
        else res = dfs(node.left, freq, oddCount) + dfs(node.right, freq, oddCount);
        freq[node.val]--;
        return res;
    }

//    private static int dfs(TreeNode node, int path) {
//        if (node == null) return 0;
//        path ^= 1 << (node.val - 1);
//        int pseudoPalindromicPathsCount = dfs(node.left, path) + dfs(node.right, path);
//        if (node.left == node.right && (path & (path - 1)) == 0) pseudoPalindromicPathsCount++;
//        return pseudoPalindromicPathsCount;
//    }

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


