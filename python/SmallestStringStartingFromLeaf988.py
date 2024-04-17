# You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters
# 'a' to 'z'. Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
# As a reminder, any shorter prefix of a string is lexicographically smaller. For example, "ab" is lexicographically
# smaller than "aba". A leaf of a node is a node that has no children.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def smallestFromLeaf(root: Optional[TreeNode]) -> str:
    def depthFirstSearch(node, path):
        path.insert(0, chr(node.val + ord('a')))
        if not node.left and not node.right:
            result = ''.join(path)
        elif node.left and node.right:
            result = min(depthFirstSearch(node.left, path), depthFirstSearch(node.right, path))
        elif node.left:
            result = depthFirstSearch(node.left, path)
        else:
            result = depthFirstSearch(node.right, path)
        path.pop(0)
        return result

    return depthFirstSearch(root, [])


if __name__ == "__main__":
    root_outer = TreeNode(0)
    root_outer.left = TreeNode(1)
    root_outer.right = TreeNode(2)
    root_outer.left.left = TreeNode(3)
    root_outer.left.right = TreeNode(4)
    root_outer.right.left = TreeNode(3)
    root_outer.right.right = TreeNode(4)
    print(smallestFromLeaf(root_outer))  # dba
