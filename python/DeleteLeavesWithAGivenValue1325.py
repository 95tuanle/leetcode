# Given a binary tree root and an integer target, delete all the leaf nodes with value target. Note that once you
# delete a leaf node with value target, if its parent node becomes a leaf node and has the value target,
# it should also be deleted (you need to continue doing that until you cannot).
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def removeLeafNodes(root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
    if root:
        root.left = removeLeafNodes(root.left, target)
        root.right = removeLeafNodes(root.right, target)
        if not root.left and not root.right and root.val == target:
            return None
    return root


if __name__ == "__main__":
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.left.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right.left = TreeNode(2)
    root.right.right = TreeNode(4)
    target = 2
    print(removeLeafNodes(root, target))
