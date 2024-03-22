# Given the head of a singly linked list, reverse the list, and return the reversed list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reverseList(head: Optional[ListNode]) -> Optional[ListNode]:
    previous = None
    while head:
        head.next, previous, head = previous, head, head.next
    return previous


if __name__ == "__main__":
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(4)
    head_outer.next.next.next.next = ListNode(5)
    head_outer = reverseList(head_outer)
    while head_outer:
        print(head_outer.val)
        head_outer = head_outer.next
