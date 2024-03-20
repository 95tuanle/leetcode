# You are given two linked lists: list1 and list2 of sizes n and m respectively.
# Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
# The blue edges and nodes in the following figure indicate the result:
# Build the result list and return its head.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def mergeInBetween(list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
    current, i = list1, 0
    while i < a - 1:
        current = current.next
        i += 1
    head = current
    while i <= b:
        current = current.next
        i += 1
    head.next = list2
    while list2.next:
        list2 = list2.next
    list2.next = current
    return list1


if __name__ == "__main__":
    list1 = ListNode(0, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))))
    list2 = ListNode(1000000, ListNode(1000001, ListNode(1000002)))
    list1 = mergeInBetween(list1, 3, 4, list2)
    while list1:
        print(list1.val)
        list1 = list1.next
    print()
    list1 = ListNode(0, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))))
    list2 = ListNode(1000000, ListNode(1000001, ListNode(1000002)))
    list1 = mergeInBetween(list1, 0, 0, list2)
    while list1:
        print(list1.val)
        list1 = list1.next
    print()
    list1 = ListNode(0, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))))
    list2 = ListNode(1000000, ListNode(1000001, ListNode(1000002)))
    list1 = mergeInBetween(list1, 0, 1, list2)
    while list1:
        print(list1.val)
        list1 = list1.next
    print()
    list1 = ListNode(0, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))))
    list2 = ListNode(1000000, ListNode(1000001, ListNode(1000002)))
    list1 = mergeInBetween(list1, 1, 4, list2)
    while list1:
        print(list1.val)
        list1 = list1.next
    print()
    list1 = ListNode(0, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))))
    list2 = ListNode(1000000, ListNode(1000001, ListNode(1000002)))
    list1 = mergeInBetween(list1, 0, 4, list2)
    while list1:
        print(list1.val)
        list1 = list1.next
