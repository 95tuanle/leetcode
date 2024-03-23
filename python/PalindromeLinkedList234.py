# Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def isPalindrome(head: Optional[ListNode]) -> bool:
    if not head or not head.next:
        return True
    slow, fast = head, head
    while fast.next and fast.next.next:
        slow, fast = slow.next, fast.next.next
    end = None
    while slow:
        slow.next, end, slow = end, slow, slow.next
    while head and end:
        if head.val != end.val:
            return False
        head, end = head.next, end.next
    return True


if __name__ == "__main__":
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(2)
    head_outer.next.next.next.next = ListNode(1)
    print(isPalindrome(head_outer))
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(4)
    head_outer.next.next.next.next = ListNode(5)
    print(isPalindrome(head_outer))
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(3)
    head_outer.next.next.next.next = ListNode(2)
    head_outer.next.next.next.next.next = ListNode(1)
    print(isPalindrome(head_outer))
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(4)
    head_outer.next.next.next.next = ListNode(4)
    head_outer.next.next.next.next.next = ListNode(3)
    head_outer.next.next.next.next.next.next = ListNode(2)
    head_outer.next.next.next.next.next.next.next = ListNode(1)
    print(isPalindrome(head_outer))
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(4)
    head_outer.next.next.next.next = ListNode(5)
    head_outer.next.next.next.next.next = ListNode(4)
    head_outer.next.next.next.next.next.next = ListNode(3)
    head_outer.next.next.next.next.next.next.next = ListNode(2)
    head_outer.next.next.next.next.next.next.next.next = ListNode(1)
    print(isPalindrome(head_outer))
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(4)
    head_outer.next.next.next.next = ListNode(5)
    head_outer.next.next.next.next.next = ListNode(5)
    head_outer.next.next.next.next.next.next = ListNode(4)
    head_outer.next.next.next.next.next.next.next = ListNode(3)
    head_outer.next.next.next.next.next.next.next.next = ListNode(2)
    head_outer.next.next.next.next.next.next.next.next.next = ListNode(1)
    print(isPalindrome(head_outer))
