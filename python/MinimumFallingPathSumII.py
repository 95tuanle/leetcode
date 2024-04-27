# Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts. A falling path
# with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in
# adjacent rows are in the same column.
from typing import List


def minFallingPathSum(grid: List[List[int]]) -> int:
    smallest, smallest_index, second_smallest = 0, -1, 0
    for row in grid:
        current_smallest, current_smallest_index, current_second_smallest = 100 + smallest, -1, 100 + second_smallest
        for key, value in enumerate(row):
            if key != smallest_index:
                value += smallest
            else:
                value += second_smallest
            if value < current_smallest:
                current_second_smallest, current_smallest, current_smallest_index = current_smallest, value, key
            elif value < current_second_smallest:
                current_second_smallest = value
        smallest, smallest_index, second_smallest = current_smallest, current_smallest_index, current_second_smallest
    return smallest


if __name__ == '__main__':
    print(minFallingPathSum([[2, 1, 3], [6, 5, 4], [7, 8, 9]]))
    print(minFallingPathSum([[-19, 57], [-40, -5]]))
    print(minFallingPathSum([[-48]]))
    print(minFallingPathSum([[100, -42, -46, -41], [31, 97, 10, -10], [-58, -51, 82, 89], [51, 81, 69, -51]]))
    print(minFallingPathSum([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
    print(minFallingPathSum([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]))
    print(minFallingPathSum([[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [11, 12, 13, 14, 15]]))
    print(minFallingPathSum([[1, 2, 3, 4, 5, 6], [7, 8, 9, 10, 11, 12], [13, 14, 15, 16, 17, 18]]))
    print(minFallingPathSum([[1, 2, 3, 4, 5, 6, 7], [8, 9, 10, 11, 12, 13, 14], [15, 16, 17, 18, 19, 20, 21]]))
    print(minFallingPathSum(
        [[1, 2, 3, 4, 5, 6, 7, 8], [9, 10, 11, 12, 13, 14, 15, 16], [17, 18, 19, 20, 21, 22, 23, 24]]))
