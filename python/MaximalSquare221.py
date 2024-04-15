# Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
from typing import List


def maximalSquare(matrix: List[List[str]]) -> int:
    rows, columns = len(matrix), len(matrix[0])
    dp = [[0] * columns for _ in range(rows)]
    max_side = 0
    for i in range(rows):
        for j in range(columns):
            if matrix[i][j] == "1":
                dp[i][j] = 1 if i == 0 or j == 0 else min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                max_side = max(max_side, dp[i][j])
    return max_side * max_side


if __name__ == '__main__':
    print(maximalSquare(
        [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"], ["1", "1", "1", "1", "1"], ["1", "0", "0", "1", "0"]]))
    print(maximalSquare([["0", "1"], ["1", "0"]]))
    print(maximalSquare([["0"]]))
    print(maximalSquare([["1"]]))
    print(maximalSquare([["0", "0"], ["0", "0"]]))
    print(maximalSquare([["1", "1"], ["1", "1"]]))
    print(maximalSquare([["1", "1", "1"], ["1", "1", "1"], ["1", "1", "1"]]))
    print(maximalSquare([["1", "1", "1", "1"], ["1", "1", "1", "1"], ["1", "1", "1", "1"], ["1", "1", "1", "1"]]))
