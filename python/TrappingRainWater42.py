# Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
# water it can trap after raining.
from typing import List


def trap(height: List[int]) -> int:
    result, left, left_max, right, right_max = 0, 0, 0, len(height) - 1, 0
    while left < right:
        if height[left] <= height[right]:
            if height[left] >= left_max:
                left_max = height[left]
            else:
                result += left_max - height[left]
            left += 1
        else:
            if height[right] >= right_max:
                right_max = height[right]
            else:
                result += right_max - height[right]
            right -= 1
    return result


if __name__ == "__main__":
    print(trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))  # 6
    print(trap([4, 2, 0, 3, 2, 5]))  # 9
    print(trap([4, 2, 3]))  # 1
    print(trap([4, 2, 3, 1]))  # 1
    print(trap([4, 2, 3, 1, 2]))  # 2
    print(trap([4, 2, 3, 1, 2, 1]))  # 2
    print(trap([4, 2, 3, 1, 2, 1, 3]))  # 6
    print(trap([4, 2, 3, 1, 2, 1, 3, 1]))  # 6
    print(trap([4, 2, 3, 1, 2, 1, 3, 1, 3]))  # 7
    print(trap([4, 2, 3, 1, 2, 1, 3, 1, 3, 2]))  # 7
    print(trap([4, 2, 3, 1, 2, 1, 3, 1, 3, 2, 1]))  # 7
    print(trap([4, 2, 3, 1, 2, 1, 3, 1, 3, 2, 1, 2]))  # 8
    print(trap([4, 2, 3, 1, 2, 1, 3, 1, 3, 2, 1, 2, 1]))  # 8
    print(trap([4, 2, 3, 1, 2, 1, 3, 1, 3, 2, 1, 2, 1, 3]))  # 9
    print(trap([4, 2, 3, 1, 2, 1, 3, 1, 3, 2, 1, 2, 1, 3, 1]))  # 9
    print(trap([4, 2, 3, 1, 2, 1, 3, 1, 3, 2, 1, 2, 1, 3, 1, 3]))  # 10
