/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
*/
public class ReverseLinkedList206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        node2.next = new ListNode(4);
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
        head = reverseList(head);
        node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null, current = head;
        while (head != null) {
            head = head.next;
            current.next = previous;
            previous = current;
            current = head;
        }
        return previous;

        // Recursive solution
//        if (head == null) return null;
//        ListNode previous = null;
//        ListNode current = head;
//        head = head.next;
//        current.next = previous;
//        if (head == null) return current;
//        while (head.next != null) {
//            previous = current;
//            current = head;
//            head = head.next;
//            current.next = previous;
//        }
//        head.next = current;
//        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}