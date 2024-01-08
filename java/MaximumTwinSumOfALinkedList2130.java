package java;

/*
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.
Given the head of a linked list with even length, return the maximum twin sum of the linked list.
*/
public class MaximumTwinSumOfALinkedList2130 {
    public static void main(String[] args) {
        System.out.println(pairSum(new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))))));
        System.out.println(pairSum(new ListNode(4, new ListNode(2, new ListNode(3, new ListNode(3))))));
        System.out.println(pairSum(new ListNode(1, new ListNode(100000))));
        System.out.println(pairSum(null));
    }

    public static int pairSum(ListNode head) {
        int[] values = new int[100000];
        int numberOfNodes = 0;
        while (head != null) {
            values[numberOfNodes++] = head.val;
            head = head.next;
        }
        int max = 0;
        for (int i = 0; i < numberOfNodes / 2; i++) max = Math.max(max, values[i] + values[numberOfNodes - 1 - i]);
        return max;

//        int numberOfNodes = 0;
//        ListNode previous = null;
//        ListNode current = head;
//        ListNode node = head;
//        while (node != null) {
//            numberOfNodes++;
//            node = node.next;
//            current.next = previous;
//            previous = current;
//            current = node;
//        }
//        int max = 0;
//        for (int i = 0; i < numberOfNodes / 2; i++) {
//            max = Math.max(max, head.val + previous.val);
//            head = head.next;
//            previous = previous.next;
//        }
//        return max;
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
