/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
*/
public class RemoveNthNodeFromEndOfList19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

        head = new ListNode(1);
        result = removeNthFromEnd(head, 1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

        head = new ListNode(1, new ListNode(2));
        result = removeNthFromEnd(head, 1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head, target = null, prev = null;
        int counter = 1;
        while (node != null) {
            if (counter == n) target = head;
            else if (counter > n) {
                target = target.next;
                if (counter == n + 1) prev = head;
                else prev = prev.next;
            }
            node = node.next;
            counter++;
        }
        if (prev == null) return head.next;
        else prev.next = target.next;
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
