# You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n
# coins in total throughout the whole tree. In one move, we may choose two adjacent nodes and move one coin from one
# node to another. A move may be from parent to child, or from child to parent. Return the minimum number of moves
#
# required to make every node have exactly one coin.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def distributeCoins(root: Optional[TreeNode]) -> int:
    def depthFirstSearch(node):
        if not node:
            return 0, 0
        left_moves, left_balance = depthFirstSearch(node.left)
        right_moves, right_balance = depthFirstSearch(node.right)
        balance = node.val - 1 + left_balance + right_balance
        return left_moves + right_moves + abs(balance), balance

    return depthFirstSearch(root)[0]


if __name__ == "__main__":
    root = TreeNode(3)
    root.left = TreeNode(0)
    root.right = TreeNode(0)
    print(distributeCoins(root))  # 2
    root = TreeNode(0)
    root.left = TreeNode(3)
    print(distributeCoins(root))  # 3
    root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(2)
    print(distributeCoins(root))  # 2
    root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(0)
    root.left.right = TreeNode(3)
    print(distributeCoins(root))  # 4
    root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(0)
    root.left.left = TreeNode(3)
    print(distributeCoins(root))  # 4
    root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(0)
    root.left.right = TreeNode(3)
    root.right.left = TreeNode(3)
    print(distributeCoins(root))  # 6
    root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(0)
    root.left.left = TreeNode(3)
    root.right.left = TreeNode(3)
    print(distributeCoins(root))  # 6
    root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(0)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(0)
    root.right.left = TreeNode(3)
