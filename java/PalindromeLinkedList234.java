/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
*/
public class PalindromeLinkedList234 {
    public static void main(String[] args) {
//        1 2 3 3 2 1
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))));
        System.out.println(isPalindrome(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        System.out.println(isPalindrome(head));

        head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode end = null, next;
        while (slow != null) {
            next = slow.next;
            slow.next = end;
            end = slow;
            slow = next;
        }
        while (head != null && end != null) {
            if (head.val != end.val) return false;
            head = head.next;
            end = end.next;
        }
        return true;
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
