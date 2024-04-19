# Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of
# islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
# You may assume all four edges of the grid are all surrounded by water.
from typing import List


def numIslands(grid: List[List[str]]) -> int:
    rows, columns = len(grid), len(grid[0])

    def depthFirstSearch(i, j):
        if i >= 0 and j >= 0 and i != rows and j != columns and grid[i][j] != '0':
            grid[i][j] = '0'
            depthFirstSearch(i - 1, j)
            depthFirstSearch(i, j - 1)
            depthFirstSearch(i + 1, j)
            depthFirstSearch(i, j + 1)

    result = 0
    for i in range(rows):
        for j in range(columns):
            if grid[i][j] == '1':
                depthFirstSearch(i, j)
                result += 1
    return result


if __name__ == '__main__':
    print(numIslands([["1", "1", "1", "1", "0"], ["1", "1", "0", "1", "0"], ["1", "1", "0", "0", "0"],
                      ["0", "0", "0", "0", "0"]]))  # 1
    print(numIslands([["1", "1", "0", "0", "0"], ["1", "1", "0", "0", "0"], ["0", "0", "1", "0", "0"],
                      ["0", "0", "0", "1", "1"]]))  # 3
    print(numIslands([["1", "0", "1", "1", "1"], ["1", "0", "1", "0", "1"], ["1", "1", "1", "0", "1"]]))  # 1
    print(numIslands([["1", "1", "1"], ["0", "1", "0"], ["1", "1", "1"]]))  # 1
    print(numIslands([["1", "0", "1"], ["0", "1", "0"], ["1", "0", "1"]]))  # 5
    print(numIslands(
        [["1", "1", "1", "1", "1", "1", "1"], ["0", "0", "0", "0", "0", "0", "1"], ["1", "1", "1", "1", "1", "0", "1"],
         ["1", "0", "0", "0", "1", "0", "1"], ["1", "0", "1", "0", "1", "0", "1"], ["1", "0", "1", "1", "1", "0", "1"],
         ["1", "1", "1", "1", "1", "1", "1"]]))  # 1
