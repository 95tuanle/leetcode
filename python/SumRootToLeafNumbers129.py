# You are given the root of a binary tree containing digits from 0 to 9 only. Each root-to-leaf path in the tree
# represents a number. For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123. Return the total sum
# of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer. A leaf node
# is a node with no children.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def sumNumbers(root: Optional[TreeNode]) -> int:
    def depthFirstSearch(number, node):
        if not node:
            return 0
        number = number * 10 + node.val
        if not node.left and not node.right:
            return number
        return depthFirstSearch(number, node.left) + depthFirstSearch(number, node.right)

    return depthFirstSearch(0, root)


if __name__ == '__main__':
    root_outer = TreeNode(1)
    root_outer.left = TreeNode(2)
    root_outer.right = TreeNode(3)
    print(sumNumbers(root_outer))
    root_outer = TreeNode(4)
    root_outer.left = TreeNode(9)
    root_outer.right = TreeNode(0)
    root_outer.left.left = TreeNode(5)
    root_outer.left.right = TreeNode(1)
    print(sumNumbers(root_outer))
    root_outer = TreeNode(1)
    root_outer.left = TreeNode(0)
    print(sumNumbers(root_outer))
    root_outer = TreeNode(1)
    root_outer.left = TreeNode(2)
    root_outer.right = TreeNode(3)
    root_outer.left.left = TreeNode(4)
    root_outer.left.right = TreeNode(5)
    root_outer.right.left = TreeNode(6)
    root_outer.right.right = TreeNode(7)
    print(sumNumbers(root_outer))
    root_outer = TreeNode(1)
    root_outer.left = TreeNode(2)
    root_outer.right = TreeNode(3)
    root_outer.left.right = TreeNode(4)
    root_outer.right.left = TreeNode(5)
    print(sumNumbers(root_outer))
    root_outer = TreeNode(4)
    root_outer.left = TreeNode(9)
    root_outer.right = TreeNode(0)
    root_outer.left.left = TreeNode(5)
    root_outer.left.right = TreeNode(1)
    root_outer.right.right = TreeNode(6)
    print(sumNumbers(root_outer))
