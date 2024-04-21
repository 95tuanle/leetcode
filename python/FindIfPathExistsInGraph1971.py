# There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The
# edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a
# bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge,
# and no vertex has an edge to itself. You want to determine if there is a valid path that exists from vertex source
# to vertex destination. Given edges and the integers n, source, and destination, return true if there is a valid
# path from source to destination, or false otherwise.
from collections import defaultdict, deque
from typing import List


def validPath(n: int, edges: List[List[int]], source: int, destination: int) -> bool:
    graph = defaultdict(list)
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)
    visited = [False] * n
    queue = deque([source])
    while queue:
        node = queue.popleft()
        if node == destination:
            return True
        for neighbor in graph[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)
    return False


if __name__ == '__main__':
    print(validPath(3, [[0, 1], [1, 2], [2, 0]], 0, 2))  # True
    print(validPath(6, [[0, 1], [0, 2], [3, 5], [5, 4], [4, 3]], 0, 5))  # False
    print(validPath(5, [[0, 1], [0, 2], [0, 4], [1, 3], [1, 4], [2, 3], [3, 4]], 0, 3))  # True
    print(validPath(5, [[0, 1], [0, 2], [0, 4], [1, 3], [1, 4], [2, 3], [3, 4]], 0, 4))  # True
    print(validPath(5, [[0, 1], [0, 2], [0, 4], [1, 3], [1, 4], [2, 3], [3, 4]], 0, 1))  # True
    print(validPath(5, [[0, 1], [0, 2], [0, 4], [1, 3], [1, 4], [2, 3], [3, 4]], 0, 0))  # True
    print(validPath(5, [[0, 1], [0, 2], [0, 4], [1, 3], [1, 4], [2, 3], [3, 4]], 0, 5))  # False  # True
