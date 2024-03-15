# Given the root of a binary tree, invert the tree, and return its root.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def invert_tree(root: Optional[TreeNode]) -> Optional[TreeNode]:
    if not root:
        return
    root.left, root.right = invert_tree(root.right), invert_tree(root.left)
    return root

    # if root:
    #     stack = [root]
    #     while stack:
    #         node = stack.pop()
    #         if node:
    #             node.left, node.right = node.right, node.left
    #             stack += node.left, node.right
    # return root


def print_tree(root: Optional[TreeNode], indent: str = ''):
    if not root:
        return
    print_tree(root.right, indent + '   ')
    print(indent, root.val)
    print_tree(root.left, indent + '   ')


if __name__ == "__main__":
    tree_root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7, TreeNode(6), TreeNode(9)))
    print_tree(tree_root)
    print_tree(invert_tree(tree_root))
