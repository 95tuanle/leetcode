# Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given
# depth depth. Note that the root node is at depth 1. The adding rule is: Given the integer depth, for each not null
# tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right
# subtree root. cur's original left subtree should be the left subtree of the new left subtree root. cur's original
# right subtree should be the right subtree of the new right subtree root. If depth == 1 that means there is no depth
# depth - 1 at all, then create a tree node with value val as the new root of the whole original tree,
# and the original tree is the new root's left subtree.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def addOneRow(root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
    if depth == 1:
        return TreeNode(val, root, None)
    elif depth == 2:
        root.left = TreeNode(val, root.left, None)
        root.right = TreeNode(val, None, root.right)
    else:
        if root.left:
            addOneRow(root.left, val, depth - 1)
        if root.right:
            addOneRow(root.right, val, depth - 1)

    return root


if __name__ == '__main__':
    root_outer = TreeNode(4)
    root_outer.left = TreeNode(2)
    root_outer.right = TreeNode(6)
    root_outer.left.left = TreeNode(3)
    root_outer.left.right = TreeNode(1)
    root_outer.right.left = TreeNode(5)
    print(addOneRow(root_outer, 1, 2))
    root_outer = TreeNode(4)
    root_outer.left = TreeNode(2)
    root_outer.right = TreeNode(6)
    root_outer.left.left = TreeNode(3)
    root_outer.left.right = TreeNode(1)
    root_outer.right.left = TreeNode(5)
    print(addOneRow(root_outer, 1, 1))
    root_outer = TreeNode(4)
    root_outer.left = TreeNode(2)
    root_outer.right = TreeNode(6)
    root_outer.left.left = TreeNode(3)
    root_outer.left.right = TreeNode(1)
    root_outer.right.left = TreeNode(5)
    print(addOneRow(root_outer, 1, 3))
    root_outer = TreeNode(4)
    root_outer.left = TreeNode(2)
    root_outer.right = TreeNode(6)
    root_outer.left.left = TreeNode(3)
    root_outer.left.right = TreeNode(1)
    root_outer.right.left = TreeNode(5)
    print(addOneRow(root_outer, 1, 4))
    root_outer = TreeNode(4)
    root_outer.left = TreeNode(2)
    root_outer.right = TreeNode(6)
    root_outer.left.left = TreeNode(3)
    root_outer.left.right = TreeNode(1)
    root_outer.right.left = TreeNode(5)
    print(addOneRow(root_outer, 1, 5))
    root_outer = TreeNode(4)
    root_outer.left = TreeNode(2)
    root_outer.right = TreeNode(6)
    root_outer.left.left = TreeNode(3)
    root_outer.left.right = TreeNode(1)
    root_outer.right.left = TreeNode(5)
    print(addOneRow(root_outer, 1, 6))
    root_outer = TreeNode(4)
    root_outer.left = TreeNode(2)
    root_outer.right = TreeNode(6)
    root_outer.left.left = TreeNode(3)
    root_outer.left.right = TreeNode(1)
    root_outer.right.left = TreeNode(5)
    print(addOneRow(root_outer, 1, 7))
