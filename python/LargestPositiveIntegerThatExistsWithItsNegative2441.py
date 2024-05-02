# Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also
# exists in the array. Return the positive integer k. If there is no such integer, return -1.
from typing import List


def findMaxK(nums: List[int]) -> int:
    result = -1
    array = [0] * 1001
    for num in nums:
        index = abs(num)
        if array[index] != num:
            array[index] += num
        if array[index] == 0:
            result = max(result, index)
    return result


if __name__ == '__main__':
    nums = [3, 2, -2, 5, -3]
    print(findMaxK(nums))  # 3
    nums = [1, 5, 3, 2, -3]
    print(findMaxK(nums))  # 3
    nums = [1, 2, 3, 4, 5]
    print(findMaxK(nums))  # -1
    nums = [1, 2, 3, 4, 5, -1, -2, -3, -4, -5]
    print(findMaxK(nums))  # 5
    nums = [1, 2, 3, 4, 5, -1, -2, -3, -4, -5, 0]
    print(findMaxK(nums))  # 5
    nums = [1, 2, 3, 4, 5, -1, -2, -3, -4, -5, 0, 0]
    print(findMaxK(nums))  # 5
    nums = [1, 2, 3, 4, 5, -1, -2, -3, -4, -5, 0, 0, 0]
    print(findMaxK(nums))  # 5
    nums = [1, 2, 3, 4, 5, -1, -2, -3, -4, -5, 0, 0, 0, 0]
    print(findMaxK(nums))  # 5
    nums = [1, 2, 3, 4, 5, -1, -2, -3, -4, -5, 0, 0, 0, 0, 0]
    print(findMaxK(nums))  # 5
    nums = [1, 2, 3, 4, 5, -1, -2, -3, -4, -5, 0, 0, 0, 0, 0, 0]
    print(findMaxK(nums))  # 5
    nums = [1, 2, 3, 4, 5, -1, -2, -3, -4, -5, 0, 0, 0, 0, 0, 0, 0]
    print(findMaxK(nums))  # 5
