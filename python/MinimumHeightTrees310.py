# A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words,
# any connected graph without simple cycles is a tree. Given a tree of n nodes labelled from 0 to n - 1, and an array
# of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi
# in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree
# has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height
# trees (MHTs). Return a list of all MHTs' root labels. You can return the answer in any order. The height of a
# rooted tree is the number of edges on the longest downward path between the root and a leaf.
from typing import List


def findMinHeightTrees(n: int, edges: List[List[int]]) -> List[int]:
    if n == 1:
        return [0]
    adj = [set() for _ in range(n)]
    for edge in edges:
        adj[edge[0]].add(edge[1])
        adj[edge[1]].add(edge[0])
    leaves = [i for i in range(n) if len(adj[i]) == 1]
    while n > 2:
        n -= len(leaves)
        new_leaves = []
        for leaf in leaves:
            i = adj[leaf].pop()
            adj[i].remove(leaf)
            if len(adj[i]) == 1:
                new_leaves.append(i)
        leaves = new_leaves
    return leaves


if __name__ == '__main__':
    print(findMinHeightTrees(4, [[1, 0], [1, 2], [1, 3]]))  # [1]
    print(findMinHeightTrees(6, [[3, 0], [3, 1], [3, 2], [3, 4], [5, 4]]))  # [3, 4]
    print(findMinHeightTrees(1, []))  # [0]
    print(findMinHeightTrees(2, [[0, 1]]))  # [0, 1]
    print(findMinHeightTrees(7, [[0, 1], [1, 2], [1, 3], [2, 4], [3, 5], [4, 6]]))  # [1, 2, 3]
    print(findMinHeightTrees(6, [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]))  # [3, 4]
    print(findMinHeightTrees(6, [[0, 1], [0, 2], [0, 3], [3, 4], [4, 5]]))  # [3]
