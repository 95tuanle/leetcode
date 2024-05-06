/*
You are given the head of a linked list.
Remove every node which has a node with a greater value anywhere to the right side of it.
Return the head of the modified linked list.
*/
public class RemoveNodesFromLinkedList2487 {
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
        head = removeNodes(head);
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
        head = removeNodes(head);
        node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode current = head;
        int currentMax = current.val;
        while (current.next != null) {
            if (current.next.val < currentMax) current.next = current.next.next;
            else {
                current = current.next;
                currentMax = current.val;
            }
        }
        return reverse(head);
    }

    private static ListNode reverse(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode nextHead = head.next;
            head.next = previous;
            previous = head;
            head = nextHead;
        }
        return previous;
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
