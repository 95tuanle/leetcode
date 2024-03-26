# Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
# You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
from typing import List


def firstMissingPositive(nums: List[int]) -> int:
    length = len(nums)
    for i in range(length):
        if nums[i] <= 0:
            nums[i] = 0
    for num in nums:
        index = abs(num) - 1
        if 0 <= index < length:
            if nums[index] > 0:
                nums[index] *= -1
            elif nums[index] == 0:
                nums[index] = -(length + 1)
    for i in range(length):
        if nums[i] >= 0:
            return i + 1
    return length + 1


if __name__ == '__main__':
    nums_outer = [3, 4, -1, 1]
    print(firstMissingPositive(nums_outer))  # 2
    nums_outer = [1, 2, 0]
    print(firstMissingPositive(nums_outer))  # 3
    nums_outer = [7, 8, 9, 11, 12]
    print(firstMissingPositive(nums_outer))  # 1
    nums_outer = [1]
    print(firstMissingPositive(nums_outer))  # 2
    nums_outer = [1, 2, 3]
    print(firstMissingPositive(nums_outer))  # 4
    nums_outer = [0, 2, 2, 1, 1]
    print(firstMissingPositive(nums_outer))  # 3
    nums_outer = [1, 1]
    print(firstMissingPositive(nums_outer))  # 2
    nums_outer = [1, 1, 1]
    print(firstMissingPositive(nums_outer))  # 2
    nums_outer = [2, 2]
    print(firstMissingPositive(nums_outer))  # 1
    nums_outer = [2, 1]
    print(firstMissingPositive(nums_outer))  # 3
    nums_outer = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    print(firstMissingPositive(nums_outer))  # 11
    nums_outer = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    print(firstMissingPositive(nums_outer))  # 12
    nums_outer = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12]
    print(firstMissingPositive(nums_outer))  # 11
    nums_outer = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    print(firstMissingPositive(nums_outer))  # 13
    nums_outer = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13]
    print(firstMissingPositive(nums_outer))  # 12
