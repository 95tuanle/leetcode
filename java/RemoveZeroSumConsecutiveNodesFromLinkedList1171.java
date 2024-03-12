/*
Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
After doing so, return the head of the final linked list.  You may return any such answer.
(Note that in the examples below, all sequences are serializations of ListNode objects.)
*/
public class RemoveZeroSumConsecutiveNodesFromLinkedList1171 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        ListNode result = removeZeroSumSublists(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0, head), start = front;
        while (start != null) {
            int prefixSum = 0;
            ListNode end = start.next;
            while (end != null) {
                prefixSum += end.val;
                if (prefixSum == 0) start.next = end.next;
                end = end.next;
            }
            start = start.next;
        }
        return front.next;
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
