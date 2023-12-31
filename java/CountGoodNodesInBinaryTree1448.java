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
        return countGoodNodes(root, root.val);
    }

    public static int countGoodNodes(TreeNode node, int max) {
        if (node == null) return 0;
        int count = 0;
        if (node.val >= max) {
            count++;
            max = node.val;
        }
        count += countGoodNodes(node.left, max);
        count += countGoodNodes(node.right, max);
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
