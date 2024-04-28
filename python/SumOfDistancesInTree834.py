# There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges. You are given the
# integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in
# the tree. Return an array answer of length n where answer[i] is the sum of the distances between the ith node in
# the tree and all other nodes.
from collections import defaultdict
from typing import List


def sumOfDistancesInTree(n: int, edges: List[List[int]]) -> List[int]:
    graph, count, result = defaultdict(list), [1] * n, [0] * n
    for i, j in edges:
        graph[i].append(j)
        graph[j].append(i)

    def depth_first_search(root, previous):
        for neighbor in graph[root]:
            if neighbor != previous:
                depth_first_search(neighbor, root)
                count[root] += count[neighbor]
                result[root] += result[neighbor] + count[neighbor]

    def depth_first_search2(root, previous):
        for neighbor in graph[root]:
            if neighbor != previous:
                result[neighbor] = result[root] - count[neighbor] + n - count[neighbor]
                depth_first_search2(neighbor, root)

    depth_first_search(0, -1)
    depth_first_search2(0, -1)
    return result


if __name__ == '__main__':
    print(sumOfDistancesInTree(6, [[0, 1], [0, 2], [2, 3], [2, 4], [2, 5]]))
    print(sumOfDistancesInTree(1, []))
    print(sumOfDistancesInTree(2, [[1, 0]]))
    print(sumOfDistancesInTree(3, [[2, 0], [1, 0]]))
    print(sumOfDistancesInTree(4, [[1, 2], [2, 0], [0, 3]]))
    print(sumOfDistancesInTree(5, [[0, 1], [0, 2], [0, 3], [2, 4]]))
