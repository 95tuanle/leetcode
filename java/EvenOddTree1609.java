import java.util.ArrayList;

/*
A binary tree is named Even-Odd if it meets the following conditions:
The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
*/
public class EvenOddTree1609 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(10, new TreeNode(3, new TreeNode(12), null), new TreeNode(4, new TreeNode(7), null)), new TreeNode(9, new TreeNode(8), new TreeNode(6, new TreeNode(11), null)));
        System.out.println(isEvenOddTree(treeNode));

        treeNode = new TreeNode(5, new TreeNode(4, new TreeNode(3), new TreeNode(3)), new TreeNode(2, new TreeNode(7), null));
        System.out.println(isEvenOddTree(treeNode));

        treeNode = new TreeNode(5, new TreeNode(9, new TreeNode(3, new TreeNode(4), null), new TreeNode(2, new TreeNode(7), null)), new TreeNode(1, new TreeNode(6), new TreeNode(8, new TreeNode(12), null)));
        System.out.println(isEvenOddTree(treeNode));

        treeNode = new TreeNode(11, new TreeNode(8, new TreeNode(1, new TreeNode(30, new TreeNode(17), null), new TreeNode(20)), new TreeNode(3, new TreeNode(18), new TreeNode(16))), new TreeNode(6, new TreeNode(9, new TreeNode(12), new TreeNode(10)), new TreeNode(11, new TreeNode(4), new TreeNode(2))));
        System.out.println(isEvenOddTree(treeNode));
//        printTree(treeNode, 0);

        treeNode = new TreeNode(2);
        System.out.println(isEvenOddTree(treeNode));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        if (root.val % 2 == 0) return false;
        ArrayList<TreeNode> nodeArrayList = new ArrayList<>();
        nodeArrayList.add(root);
        int start = 0, end = 1;
        final int MAX = (int) Math.pow(10, 6) + 1;
        boolean isPresviouslyOdd = true;
        while (start < end) {
            int currentNumber = isPresviouslyOdd ? MAX : 0;
            for (int i = start; i < end; i++) {
                TreeNode currentNode = nodeArrayList.get(i);
                if (currentNode.left != null) {
                    TreeNode assessingNode = currentNode.left;
                    if (isPresviouslyOdd) {
                        if (assessingNode.val % 2 != 0 || assessingNode.val >= currentNumber) return false;
                    } else if (assessingNode.val % 2 == 0 || assessingNode.val <= currentNumber) return false;
                    currentNumber = assessingNode.val;
                    nodeArrayList.add(assessingNode);
                }
                if (currentNode.right != null) {
                    TreeNode assessingNode = currentNode.right;
                    if (isPresviouslyOdd) {
                        if (assessingNode.val % 2 != 0 || assessingNode.val >= currentNumber) return false;
                    } else if (assessingNode.val % 2 == 0 || assessingNode.val <= currentNumber) return false;
                    currentNumber = assessingNode.val;
                    nodeArrayList.add(assessingNode);
                }
            }
            if (nodeArrayList.size() != end) {
                isPresviouslyOdd = !isPresviouslyOdd;
                start = end;
                end = nodeArrayList.size();
            } else break;
        }
        return true;

//        if (root.val % 2 == 0) return false;
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        final int MAX = (int) Math.pow(10, 6) + 1;
//        boolean isPreviouslyOdd = true;
//        while (!queue.isEmpty()) {
//            int currentNumber = isPreviouslyOdd ? MAX : 0;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode currentNode = queue.poll();
//                assert currentNode != null;
//                if (currentNode.left != null) {
//                    if (isPreviouslyOdd) {
//                        if (currentNode.left.val % 2 != 0 || currentNode.left.val >= currentNumber) return false;
//                    } else if (currentNode.left.val % 2 == 0 || currentNode.left.val <= currentNumber) return false;
//                    currentNumber = currentNode.left.val;
//                    queue.add(currentNode.left);
//                }
//                if (currentNode.right != null) {
//                    if (isPreviouslyOdd) {
//                        if (currentNode.right.val % 2 != 0 || currentNode.right.val >= currentNumber) return false;
//                    } else if (currentNode.right.val % 2 == 0 || currentNode.right.val <= currentNumber) return false;
//                    currentNumber = currentNode.right.val;
//                    queue.add(currentNode.right);
//                }
//            }
//            isPreviouslyOdd = !isPreviouslyOdd;
//        }
//        return true;
    }

//    public static void printTree(TreeNode root, int space) {
//        // Base case
//        if (root == null) return;
//
//        // Increase distance between levels
//        space += 10;
//
//        // Process right child first
//        printTree(root.right, space);
//
//        // Print current node after space count
//        System.out.print("\n");
//        for (int i = 10; i < space; i++)
//            System.out.print(" ");
//        System.out.print(root.val + "\n");
//
//        // Process left child
//        printTree(root.left, space);
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
