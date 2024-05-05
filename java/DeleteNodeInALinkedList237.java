/*
There is a singly-linked list head and we want to delete a node node in it.
You are given the node to be deleted node. You will not be given access to the first node of head.
All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
The value of the given node should not exist in the linked list.
The number of nodes in the linked list should decrease by one.
All the values before node should be in the same order.
All the values after node should be in the same order.
Custom testing:
For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
We will build the linked list and pass the node to your function.
The output will be the entire list after calling your function.
*/
public class DeleteNodeInALinkedList237 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        head.next = node1;
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3 = new ListNode(9);
        node2.next = node3;
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
        deleteNode(node1);
        node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
        head = new ListNode(1);
        node1 = new ListNode(2);
        head.next = node1;
        node2 = new ListNode(3);
        node1.next = node2;
        node3 = new ListNode(4);
        node2.next = node3;
        node3.next = new ListNode(5);
        node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
        deleteNode(node2);
        node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

//        ListNode previous = node;
//        while (node.next != null) {
//            node.val = node.next.val;
//            previous = node;
//            node = node.next;
//        }
//        previous.next = null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
