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
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    head = reverseList(head)
    while head:
        print(head.val)
        head = head.next
