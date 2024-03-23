# You are given the head of a singly linked-list. The list can be represented as:
# L0 → L1 → … → Ln - 1 → Ln
# Reorder the list to be on the following form:
# L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
# You may not modify the values in the list's nodes. Only nodes themselves may be changed.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reorderList(head: Optional[ListNode]) -> None:
    if not head or not head.next:
        return
    slow, fast = head, head
    while fast.next and fast.next.next:
        slow, fast = slow.next, fast.next.next
    end = None
    while slow:
        slow.next, end, slow = end, slow, slow.next
    while head and end:
        head.next, end.next, head, end = end, head.next, head.next, end.next


if __name__ == "__main__":
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(4)
    head_outer.next.next.next.next = ListNode(5)
    reorderList(head_outer)
    while head_outer:
        print(head_outer.val, end=" -> ")
        head_outer = head_outer.next
    print()
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(4)
    head_outer.next.next.next.next = ListNode(5)
    head_outer.next.next.next.next.next = ListNode(6)
    reorderList(head_outer)
    while head_outer:
        print(head_outer.val, end=" -> ")
        head_outer = head_outer.next
    print()
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(4)
    head_outer.next.next.next.next = ListNode(5)
    head_outer.next.next.next.next.next = ListNode(6)
    head_outer.next.next.next.next.next.next = ListNode(7)
    reorderList(head_outer)
    while head_outer:
        print(head_outer.val, end=" -> ")
        head_outer = head_outer.next
    print()
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(4)
    head_outer.next.next.next.next = ListNode(5)
    head_outer.next.next.next.next.next = ListNode(6)
    head_outer.next.next.next.next.next.next = ListNode(7)
    head_outer.next.next.next.next.next.next.next = ListNode(8)
    reorderList(head_outer)
    while head_outer:
        print(head_outer.val, end=" -> ")
        head_outer = head_outer.next
