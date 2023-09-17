/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.
*/
public class CountGoodNodesInBinaryTree1448 {
    public static void main(String[] args) {
        System.out.println(goodNodes(new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)))));
        System.out.println(goodNodes(new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null)));
    }

    public static int goodNodes(TreeNode root) {
        int count = 1;
        count += depthFirstSearch(root.left, root.val);
        count += depthFirstSearch(root.right, root.val);
        return count;
    }

    public static int depthFirstSearch(TreeNode root, int max) {
        int count = 0;
        if (root != null) {
            if (root.val >= max) {
                count++;
                count += depthFirstSearch(root.left, root.val);
                count += depthFirstSearch(root.right, root.val);
            } else {
                count += depthFirstSearch(root.left, max);
                count += depthFirstSearch(root.right, max);
            }
        }
        return count;
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
