/*
You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
Return the head of the linked list after doubling it.
*/
public class DoubleANumberRepresentedAsALinkedList2816 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        node2.next = new ListNode(9);
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
        head = doubleIt(head);
        node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode doubleIt(ListNode head) {
        if (head.val > 4) head = new ListNode(0, head);
        ListNode node = head;
        while (node != null) {
            node.val = (node.val * 2) % 10;
            if (node.next != null && node.next.val > 4) node.val++;
            node = node.next;
        }
        return head;
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
