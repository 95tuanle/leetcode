# You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
# Return the head of the linked list after doubling it.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def doubleIt(head: Optional[ListNode]) -> Optional[ListNode]:
    if head.val > 4:
        head = ListNode(0, head)
    node = head
    while node:
        node.val = (node.val * 2) % 10
        if node.next and node.next.val > 4:
            node.val += 1
        node = node.next
    return head


if __name__ == "__main__":
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(4)
    head_outer.next.next.next.next = ListNode(5)
    head_outer = doubleIt(head_outer)
    while head_outer:
        print(head_outer.val, end=' ')
        head_outer = head_outer.next
    print()
    head_outer = ListNode(9)
    head_outer.next = ListNode(9)
    head_outer.next.next = ListNode(9)
    head_outer = doubleIt(head_outer)
    while head_outer:
        print(head_outer.val, end=' ')
        head_outer = head_outer.next
    print()
    head_outer = ListNode(9)
    head_outer.next = ListNode(9)
    head_outer.next.next = ListNode(9)
    head_outer.next.next.next = ListNode(9)
    head_outer = doubleIt(head_outer)
    while head_outer:
        print(head_outer.val, end=' ')
        head_outer = head_outer.next
    print()
    head_outer = ListNode(9)
    head_outer.next = ListNode(9)
    head_outer.next.next = ListNode(9)
    head_outer.next.next.next = ListNode(9)
    head_outer.next.next.next.next = ListNode(9)
    head_outer = doubleIt(head_outer)
    while head_outer:
        print(head_outer.val, end=' ')
        head_outer = head_outer.next
    print()
    head_outer = ListNode(9)
    head_outer.next = ListNode(9)
    head_outer.next.next = ListNode(9)
    head_outer.next.next.next = ListNode(9)
    head_outer.next.next.next.next = ListNode(9)
    head_outer.next.next.next.next.next = ListNode(9)
    head_outer = doubleIt(head_outer)
    while head_outer:
        print(head_outer.val, end=' ')
        head_outer = head_outer.next
    print()
    head_outer = ListNode(9)
    head_outer.next = ListNode(9)
    head_outer.next.next = ListNode(9)
    head_outer.next.next.next = ListNode(9)
    head_outer.next.next.next.next = ListNode(9)
    head_outer.next.next.next.next.next = ListNode(9)
    head_outer.next.next.next.next.next.next = ListNode(9)
    head_outer = doubleIt(head_outer)
    while head_outer:
        print(head_outer.val, end=' ')
        head_outer = head_outer.next
