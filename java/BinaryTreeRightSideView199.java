
import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
*/
public class BinaryTreeRightSideView199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        System.out.println(rightSideView(root));
        TreeNode root2 = new TreeNode(1, null, new TreeNode(3));
        System.out.println(rightSideView(root2));
        TreeNode root3 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(rightSideView(root3));
        System.out.println(rightSideView(null));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public static void rightView(TreeNode currentNode, List<Integer> result, int currentDepth) {
        if (currentNode == null) return;
        if (result.size() == currentDepth) result.add(currentNode.val);
        rightView(currentNode.right, result, currentDepth + 1);
        rightView(currentNode.left, result, currentDepth + 1);
    }

//    public static List<Integer> rightSideView(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) return result;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int sizeOfLevel = queue.size();
//            for (int i = 0; i < sizeOfLevel; i++) {
//                TreeNode currentNode = queue.poll();
//                assert currentNode != null;
//                if (i == sizeOfLevel - 1) result.add(currentNode.val);
//                if (currentNode.left != null) queue.offer(currentNode.left);
//                if (currentNode.right != null) queue.offer(currentNode.right);
//            }
//        }
//        return result;
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
