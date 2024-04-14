# Given the root of a binary tree, return the sum of all left leaves.
# A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def sumOfLeftLeaves(root: Optional[TreeNode]) -> int:
    if not root:
        return 0
    if root.left and not root.left.left and not root.left.right:
        return root.left.val + sumOfLeftLeaves(root.right)
    else:
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right)


if __name__ == '__main__':
    root_outer = TreeNode(3)
    root_outer.left = TreeNode(9)
    root_outer.right = TreeNode(20)
    root_outer.right.left = TreeNode(15)
    root_outer.right.right = TreeNode(7)
    print(sumOfLeftLeaves(root_outer))  # Output 24
