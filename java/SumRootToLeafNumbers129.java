/*
You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.
For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
A leaf node is a node with no children.
*/
public class SumRootToLeafNumbers129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(sumNumbers(root));

        root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        return depthFirstSearch(0, root);
    }

    private static int depthFirstSearch(int number, TreeNode node) {
        if (node == null) return 0;
        number = number * 10 + node.val;
        if (node.left == null && node.right == null) return number;
        return depthFirstSearch(number, node.left) + depthFirstSearch(number, node.right);
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
