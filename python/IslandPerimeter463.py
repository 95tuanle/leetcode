# You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents
# water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by
# water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes",
# meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1.
# The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
from typing import List


def islandPerimeter(grid: List[List[int]]) -> int:
    rows, columns, result = len(grid), len(grid[0]), 0
    for i in range(rows):
        for j in range(columns):
            if grid[i][j] == 1:
                if i == 0 or grid[i - 1][j] == 0:
                    result += 1
                if j == 0 or grid[i][j - 1] == 0:
                    result += 1
                if i == rows - 1 or grid[i + 1][j] == 0:
                    result += 1
                if j == columns - 1 or grid[i][j + 1] == 0:
                    result += 1
    return result


if __name__ == '__main__':
    print(islandPerimeter([[0, 1, 0, 0], [1, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]))  # 16
    print(islandPerimeter([[1]]))  # 4
    print(islandPerimeter([[1, 0]]))  # 4
    print(islandPerimeter([[1, 1]]))  # 6
    print(islandPerimeter([[0, 1, 0, 0], [1, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]))  # 16
    print(islandPerimeter([[1, 1, 1, 1], [1, 0, 0, 1], [1, 1, 1, 1]]))  # 18
    print(islandPerimeter([[1, 0], [1, 1]]))  # 8
    print(islandPerimeter([[1, 1], [1, 1]]))  # 8
    print(islandPerimeter([[1, 1, 1], [1, 1, 1], [1, 1, 1]]))  # 12
    print(islandPerimeter([[0, 0, 0], [0, 0, 0], [0, 0, 0]]))  # 0
    print(islandPerimeter([[1, 0, 0], [0, 0, 0], [0, 0, 0]]))  # 4
    print(islandPerimeter([[1, 1, 1], [1, 0, 0], [1, 0, 0]]))  # 12
    print(islandPerimeter([[1, 1, 1], [1, 0, 1], [1, 1, 1]]))  # 14
