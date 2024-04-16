# Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and
# return its area.
from typing import List


def maximalRectangle(matrix: List[List[str]]) -> int:
    max_area, length, stack = 0, len(matrix[0]), [-1]
    heights = [0] * length
    for row in matrix:
        for i in range(length):
            if row[i] == '1':
                heights[i] += 1
            else:
                heights[i] = 0
            while stack[-1] != -1 and heights[i] <= heights[stack[-1]]:
                max_area = max(max_area, heights[stack.pop()] * (i - 1 - stack[-1]))
            stack.append(i)
        while stack[-1] != -1:
            max_area = max(max_area, heights[stack.pop()] * (length - 1 - stack[-1]))
    return max_area


if __name__ == '__main__':
    print(maximalRectangle([["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"], ["1", "1", "1", "1", "1"],
                            ["1", "0", "0", "1", "0"]]))  # 6
    print(maximalRectangle([["0"]]))  # 0
    print(maximalRectangle([["1"]]))  # 1
    print(maximalRectangle([["0", "0"]]))  # 0
    print(maximalRectangle([["1", "1"]]))  # 2
    print(maximalRectangle([["0", "1"]]))  # 1
    print(maximalRectangle([["1", "0"]]))  # 1
    print(maximalRectangle([["0", "0"], ["0", "0"]]))  # 0
    print(maximalRectangle([["1", "1"], ["1", "1"]]))  # 4
    print(maximalRectangle([["0", "1"], ["1", "1"]]))  # 3
    print(maximalRectangle([["1", "0"], ["1", "1"]]))  # 2
    print(maximalRectangle([["1", "1"], ["0", "1"]]))  # 2
    print(maximalRectangle([["1", "1"], ["1", "0"]]))  # 2
    print(maximalRectangle([["0", "1"], ["1", "0"]]))  # 1
    print(maximalRectangle([["1", "0"], ["0", "1"]]))  # 1
    print(maximalRectangle([["0", "1"], ["0", "1"]]))  # 2
    print(maximalRectangle([["1", "0"], ["1", "0"]]))  # 1
    print(maximalRectangle([["0", "1"], ["1", "0"]]))  # 1
    print(maximalRectangle([["1", "0"], ["0", "1"]]))  # 1
