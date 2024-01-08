
/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
Basically, the deletion can be divided into two stages:
Search for a node to remove.
If the node is found, delete the node.
*/
public class DeleteNodeInABST450 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        TreeNode result = deleteNode(root, 3);
        System.out.println(result);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.right == null && root.left == null) return null;
            else if (root.right != null) {
                if (root.left != null) {
                    TreeNode mostLeftNode = root.right;
                    while (mostLeftNode.left != null) mostLeftNode = mostLeftNode.left;
                    mostLeftNode.left = root.left;
                }
                root = root.right;
            } else root = root.left;
            return root;
        }
        TreeNode previous = root;
        while (true) if (previous.val > key) {
            if (previous.left == null) break;
            TreeNode target = previous.left;
            if (target.val != key) previous = target;
            else {
                if (target.right == null && target.left == null) previous.left = null;
                else if (target.right != null) {
                    if (target.left != null) {
                        TreeNode mostLeftNode = target.right;
                        while (mostLeftNode.left != null) mostLeftNode = mostLeftNode.left;
                        mostLeftNode.left = target.left;
                    }
                    previous.left = target.right;
                } else previous.left = target.left;
                break;
            }
        } else {
            if (previous.right == null) break;
            TreeNode target = previous.right;
            if (target.val != key) previous = target;
            else {
                if (target.right == null && target.left == null) previous.right = null;
                else if (target.right != null) {
                    if (target.left != null) {
                        TreeNode mostLeftNode = target.right;
                        while (mostLeftNode.left != null) mostLeftNode = mostLeftNode.left;
                        mostLeftNode.left = target.left;
                    }
                    previous.right = target.right;
                } else previous.right = target.left;
                break;
            }
        }
        return root;
    }

//    public static TreeNode deleteNode(TreeNode root, int key) {
//        if (root == null) return null;
//        if (key < root.val) root.left = deleteNode(root.left, key);
//        else if (key > root.val) root.right = deleteNode(root.right, key);
//        else {
//            if (root.left == null) return root.right;
//            else if (root.right == null) return root.left;
//            root.val = findMinValue(root.right);
//            root.right = deleteNode(root.right, root.val);
//        }
//        return root;
//    }
//
//    private static int findMinValue(TreeNode node) {
//        int minValue = node.val;
//        while (node.left != null) {
//            minValue = node.left.val;
//            node = node.left;
//        }
//        return minValue;
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
