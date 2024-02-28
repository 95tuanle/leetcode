import java.util.LinkedList;

/*
Given the root of a binary tree, return the leftmost value in the last row of the tree.
*/
public class FindBottomLeftTreeValue513 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(findBottomLeftValue(treeNode));

        treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));
        System.out.println(findBottomLeftValue(treeNode));

        treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        System.out.println(findBottomLeftValue(treeNode));
    }

    public static int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        TreeNode currentNode = null;
        while (!linkedList.isEmpty()) {
            currentNode = linkedList.poll();
            if (currentNode.right != null) linkedList.add(currentNode.right);
            if (currentNode.left != null) linkedList.add(currentNode.left);
        }
        return currentNode.val;

//        ArrayList<TreeNode> nodeArrayList = new ArrayList<>();
//        nodeArrayList.add(root);
//        int start = 0, end = 1;
//        while (start < end) {
//            for (int i = start; i < end; i++) {
//                TreeNode currentNode = nodeArrayList.get(i);
//                if (currentNode.left != null) nodeArrayList.add(currentNode.left);
//                if (currentNode.right != null) nodeArrayList.add(currentNode.right);
//            }
//            if (nodeArrayList.size() != end) {
//                start = end;
//                end = nodeArrayList.size();
//            } else break;
//        }
//        return nodeArrayList.get(start).val;

//        return breathFirstSearch(nodeArrayList);
    }

//    private static int breathFirstSearch(ArrayList<TreeNode> nodeArrayList) {
//        ArrayList<TreeNode> nextNodeArrayList = new ArrayList<>();
//        for (TreeNode treeNode : nodeArrayList) {
//            if (treeNode.left != null) nextNodeArrayList.add(treeNode.left);
//            if (treeNode.right != null) nextNodeArrayList.add(treeNode.right);
//        }
//        if (nextNodeArrayList.isEmpty()) return nodeArrayList.getFirst().val;
//        return breathFirstSearch(nextNodeArrayList);
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
