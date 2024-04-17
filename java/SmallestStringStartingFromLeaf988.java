import java.util.Objects;

/*
You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.
Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
As a reminder, any shorter prefix of a string is lexicographically smaller.
For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.
*/
public class SmallestStringStartingFromLeaf988 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(smallestFromLeaf(root));


        root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);
        System.out.println(smallestFromLeaf(root));
    }

    public static String smallestFromLeaf(TreeNode root) {
        return depthFirstSearch(root, new StringBuilder());
    }

    private static String depthFirstSearch(TreeNode root, StringBuilder stringBuilder) {
        stringBuilder.insert(0, (char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            String result = stringBuilder.toString();
            stringBuilder.deleteCharAt(0);
            return result;
        } else if (root.left != null && root.right != null) {
            String left = depthFirstSearch(root.left, stringBuilder), right = depthFirstSearch(root.right, stringBuilder);
            stringBuilder.deleteCharAt(0);
            return left.compareTo(right) < 0 ? left : right;
        } else {
            String result = depthFirstSearch(Objects.requireNonNullElseGet(root.left, () -> root.right), stringBuilder);
            stringBuilder.deleteCharAt(0);
            return result;
        }
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
