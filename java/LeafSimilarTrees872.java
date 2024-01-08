
import java.util.ArrayList;
import java.util.List;

/*
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
*/
public class LeafSimilarTrees872 {
    public static void main(String[] args) {
        System.out.println(leafSimilar(new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(9), new TreeNode(8))), new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(7)), new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))))));
        System.out.println(leafSimilar(new TreeNode(1), new TreeNode(1)));
        System.out.println(leafSimilar(new TreeNode(1), new TreeNode(2)));
        System.out.println(leafSimilar(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(3), new TreeNode(2))));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        depthFirstSearch(root1, leaves1);
        depthFirstSearch(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public static void depthFirstSearch(TreeNode root, List<Integer> leaves) {
        if (root != null) {
            if (root.left == null && root.right == null) leaves.add(root.val);
            else {
                depthFirstSearch(root.left, leaves);
                depthFirstSearch(root.right, leaves);
            }
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
