# There is a bidirectional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges
# in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bidirectional
# edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge
# to itself. You want to determine if there is a valid path that exists from vertex source to vertex destination.
# Given edges and the integers n, source, and destination, return true if there is a valid path from source to
# destination, or false otherwise.
from typing import List


def validPath(n: int, edges: List[List[int]], source: int, destination: int) -> bool:
    parent = [i for i in range(n)]

    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]

    for vertex0, vertex1 in edges:
        parent0, parent1 = find(vertex0), find(vertex1)
        if parent0 != parent1:
            parent[parent0] = parent1
    return find(source) == find(destination)

    # graph = defaultdict(list)
    # for i, j in edges:
    #     graph[i].append(j)
    #     graph[j].append(i)
    # visited = [False] * n
    # queue = deque([source])
    # while queue:
    #     node = queue.popleft()
    #     if node == destination:
    #         return True
    #     for neighbor in graph[node]:
    #         if not visited[neighbor]:
    #             visited[neighbor] = True
    #             queue.append(neighbor)
    # return False


if __name__ == '__main__':
    print(validPath(3, [[0, 1], [1, 2], [2, 0]], 0, 2))  # True
    print(validPath(6, [[0, 1], [0, 2], [3, 5], [5, 4], [4, 3]], 0, 5))  # False
    print(validPath(5, [[0, 1], [0, 2], [0, 4], [1, 3], [1, 4], [2, 3], [3, 4]], 0, 3))  # True
    print(validPath(5, [[0, 1], [0, 2], [0, 4], [1, 3], [1, 4], [2, 3], [3, 4]], 0, 4))  # True
    print(validPath(5, [[0, 1], [0, 2], [0, 4], [1, 3], [1, 4], [2, 3], [3, 4]], 0, 1))  # True
    print(validPath(5, [[0, 1], [0, 2], [0, 4], [1, 3], [1, 4], [2, 3], [3, 4]], 0, 0))  # True
    print(validPath(5, [[0, 1], [0, 2], [0, 4], [1, 3], [1, 4], [2, 3], [3, 4]], 0, 5))  # False  # True
