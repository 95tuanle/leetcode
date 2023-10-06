import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
*/
public class MaximumLevelSumOfABinaryTree1161 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
        System.out.println(maxLevelSum(root));

        TreeNode root2 = new TreeNode(989, null, new TreeNode(10250, new TreeNode(98693), null));
        System.out.println(maxLevelSum(root2));
    }

    public static int maxLevelSum(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        return maxLevelSum(list, root.val, 1, 1);
    }

    private static int maxLevelSum(List<TreeNode> list, int maxSum, int maxLevel, int currentLevel) {
        if (list.isEmpty()) return maxLevel;
        int sum = 0;
        List<TreeNode> nextLevel = new ArrayList<>();
        for (TreeNode node : list) {
            sum += node.val;
            if (node.left != null) nextLevel.add(node.left);
            if (node.right != null) nextLevel.add(node.right);
        }
        if (sum > maxSum) {
            maxSum = sum;
            maxLevel = currentLevel;
        }
        return maxLevelSum(nextLevel, maxSum, maxLevel, currentLevel + 1);
    }

//    public static int maxLevelSum(TreeNode root) {
//        if (root == null) return 0;
//        int maxSum = root.val, maxLevel = 1, currentLevel = 1;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int sizeOfLevel = queue.size();
//            int sum = 0;
//            for (int i = 0; i < sizeOfLevel; i++) {
//                TreeNode node = queue.poll();
//                assert node != null;
//                sum += node.val;
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//            }
//            if (sum > maxSum) {
//                maxSum = sum;
//                maxLevel = currentLevel;
//            }
//            currentLevel++;
//        }
//        return maxLevel;
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
