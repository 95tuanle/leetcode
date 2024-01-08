
import java.util.ArrayList;

/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
*/
public class PathSumIII437 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        System.out.println(pathSum(root, 8));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.left.left = new TreeNode(11);
        root2.left.left.left = new TreeNode(7);
        root2.left.left.right = new TreeNode(2);
        root2.right = new TreeNode(8);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(4);
        root2.right.right.left = new TreeNode(5);
        root2.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root2, 22));

        TreeNode root3 = new TreeNode(1000000000);
        root3.left = new TreeNode(1000000000);
        root3.left.left = new TreeNode(294967296);
        root3.left.right = new TreeNode(1000000000);
        root3.left.right.left = new TreeNode(1000000000);
        root3.right = new TreeNode(1000000000);
        root3.right.right = new TreeNode(1000000000);
        root3.right.right.left = new TreeNode(1000000000);
        root3.right.right.right = new TreeNode(1000000000);

        System.out.println(pathSum(root3, 0));

        TreeNode root4 = new TreeNode(1000000000);
        root4.left = new TreeNode(1000000000);
        root4.left.left = new TreeNode(294967296);
        root4.left.left.left = new TreeNode(1000000000);
        root4.left.left.left.left = new TreeNode(1000000000);
        root4.left.left.left.left.left = new TreeNode(1000000000);

        System.out.println(pathSum(root4, 0));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum, new ArrayList<>());
    }

    private static int solve(TreeNode root, int targetSum, ArrayList<TreeNode> path) {
        if (root == null) return 0;
        path.add(root);
        int count = 0;
        long sum = 0; // sum can be negative and can exceed Integer.MAX_VALUE
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i).val;
            if (sum == targetSum) count++;
        }
        count += solve(root.left, targetSum, path);
        count += solve(root.right, targetSum, path);
        path.remove(path.size() - 1);
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
