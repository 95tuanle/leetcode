# You are given an integer array nums and two integers minK and maxK.
# A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
# The minimum value in the subarray is equal to minK.
# The maximum value in the subarray is equal to maxK.
# Return the number of fixed-bound subarrays.
# A subarray is a contiguous part of an array.
from typing import List


def countSubarrays(nums: List[int], minK: int, maxK: int) -> int:
    result, invalidIndex, minIndex, maxIndex = 0, -1, -1, -1
    for i, v in enumerate(nums):
        if v < minK or v > maxK:
            invalidIndex = i
        if v == minK:
            minIndex = i
        if v == maxK:
            maxIndex = i
        result += max(0, min(minIndex, maxIndex) - invalidIndex)
    return result


if __name__ == "__main__":
    print(countSubarrays([3, 4, 1, 6, 2], 1, 4))  # 5
    print(countSubarrays([2, 2, 2, 1, 2, 2, 1, 2, 2, 2], 2, 2))  # 21
    print(countSubarrays([2, 1, 4, 3], 2, 3))  # 3
    print(countSubarrays([1, 2, 1, 2, 1, 2, 1], 1, 2))  # 14
    print(countSubarrays([1, 1, 1, 1], 1, 1))  # 10
    print(countSubarrays([1, 2, 3, 4], 1, 10))  # 10
    print(countSubarrays([1, 2, 3, 4], 10, 1))  # 0
    print(countSubarrays([1, 2, 3, 4], 1, 1))  # 0
    print(countSubarrays([1, 2, 3, 4], 4, 4))  # 1
    print(countSubarrays([1, 2, 3, 4], 2, 3))  # 3
    print(countSubarrays([1, 2, 3, 4], 3, 2))  # 3
    print(countSubarrays([1, 2, 3, 4], 2, 2))  # 2
    print(countSubarrays([1, 2, 3, 4], 3, 3))  # 2
    print(countSubarrays([1, 2, 3, 4], 1, 2))  # 3
    print(countSubarrays([1, 2, 3, 4], 2, 1))  # 3
    print(countSubarrays([1, 2, 3, 4], 1, 1))  # 1
    print(countSubarrays([1, 2, 3, 4], 4, 4))  # 1
