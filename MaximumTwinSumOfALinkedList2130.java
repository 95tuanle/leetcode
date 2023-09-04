/*
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.
Given the head of a linked list with even length, return the maximum twin sum of the linked list.
*/
public class MaximumTwinSumOfALinkedList2130 {
    public static void main(String[] args) {
        System.out.println(pairSum(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
        System.out.println(pairSum(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
        System.out.println(pairSum(new ListNode(1, new ListNode(2))));
        System.out.println(pairSum(new ListNode(1)));
        System.out.println(pairSum(null));
    }

    public static int pairSum(ListNode head) {
        return 0;
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
