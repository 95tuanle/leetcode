# You are given the head of a linked list.
# Remove every node which has a node with a greater value anywhere to the right side of it.
# Return the head of the modified linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def removeNodes(head: Optional[ListNode]) -> Optional[ListNode]:
    def reverse(node):
        previous = None
        while node:
            node.next, node, previous = previous, node.next, node
        return previous

    head = reverse(head)
    current = head
    current_max = current.val
    while current.next:
        if current.next.val < current_max:
            current.next = current.next.next
        else:
            current = current.next
            current_max = current.val
    return reverse(head)


if __name__ == "__main__":
    head_outer = ListNode(1)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(4)
    head_outer.next.next.next.next = ListNode(5)
    head_outer = removeNodes(head_outer)
    while head_outer:
        print(head_outer.val, end=' ')
        head_outer = head_outer.next
    print()
    head_outer = ListNode(5)
    head_outer.next = ListNode(2)
    head_outer.next.next = ListNode(3)
    head_outer.next.next.next = ListNode(8)
    head_outer.next.next.next.next = ListNode(6)
    head_outer.next.next.next.next.next = ListNode(1)
    head_outer.next.next.next.next.next.next = ListNode(7)
    head_outer = removeNodes(head_outer)
    while head_outer:
        print(head_outer.val, end=' ')
        head_outer = head_outer.next
    print()
    head_outer = ListNode(4)
    head_outer.next = ListNode(5)
    head_outer.next.next = ListNode(2)
    head_outer.next.next.next = ListNode(3)
    head_outer.next.next.next.next = ListNode(8)
    head_outer.next.next.next.next.next = ListNode(6)
    head_outer.next.next.next.next.next.next = ListNode(1)
    head_outer.next.next.next.next.next.next.next = ListNode(7)
    head_outer = removeNodes(head_outer)
    while head_outer:
        print(head_outer.val, end=' ')
        head_outer = head_outer.next
    print()
    head_outer = ListNode(4)
    head_outer.next = ListNode(5)
    head_outer.next.next = ListNode(2)
    head_outer.next.next.next = ListNode(3)
    head_outer.next.next.next.next = ListNode(8)
    head_outer.next.next.next.next.next = ListNode(6)
    head_outer.next.next.next.next.next.next = ListNode(1)
    head_outer.next.next.next.next.next.next.next = ListNode(7)
    head_outer = removeNodes(head_outer)
    while head_outer:
        print(head_outer.val, end=' ')
        head_outer = head_outer.next
    print()
    head_outer = ListNode(4)
    head_outer.next = ListNode(5)
    head_outer.next.next = ListNode(2)
    head_outer.next.next.next = ListNode(3)
    head_outer.next.next.next.next = ListNode(8)
    head_outer.next.next.next.next.next = ListNode(6)
    head_outer.next.next.next.next.next.next = ListNode(1)
    head_outer.next.next.next.next.next.next.next = ListNode(7)
    head_outer = removeNodes(head_outer)
    while head_outer:
        print(head_outer.val, end=' ')
        head_outer = head_outer.next
