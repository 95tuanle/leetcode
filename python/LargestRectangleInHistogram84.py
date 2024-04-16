# Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
# return the area of the largest rectangle in the histogram.
from typing import List


def largestRectangleArea(heights: List[int]) -> int:
    stack, largest, length = [-1], 0, len(heights)
    for i in range(length):
        while stack[-1] != -1 and heights[i] <= heights[stack[-1]]:
            largest = max(largest, heights[stack.pop()] * (i - 1 - stack[-1]))
        stack.append(i)
    while stack[-1] != -1:
        largest = max(largest, heights[stack.pop()] * (length - 1 - stack[-1]))
    return largest


if __name__ == '__main__':
    print(largestRectangleArea([2, 1, 5, 6, 2, 3]))  # 10
    print(largestRectangleArea([2, 4]))  # 4
    print(largestRectangleArea([2, 1, 2]))  # 3
    print(largestRectangleArea([1, 2, 3, 4, 5, 6, 7, 8]))  # 20
    print(largestRectangleArea([1, 2, 3, 4, 5, 6, 7, 8, 9]))  # 25
    print(largestRectangleArea([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))  # 30
    print(largestRectangleArea([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]))  # 33
    print(largestRectangleArea([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]))  # 36
    print(largestRectangleArea([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]))  # 39
    print(largestRectangleArea([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]))  # 42
    print(largestRectangleArea([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]))  # 45
    print(largestRectangleArea([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]))  # 48
