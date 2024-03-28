# You are given an integer array nums and an integer k.
# The frequency of an element x is the number of times it occurs in an array.
# An array is called good if the frequency of each element in this array is less than or equal to k.
# Return the length of the longest good subarray of nums.
# A subarray is a contiguous non-empty sequence of elements within an array.
from collections import defaultdict
from typing import List


def maxSubarrayLength(nums: List[int], k: int) -> int:
    result = 0
    frequencies = defaultdict(int)
    left = 0
    for right in range(len(nums)):
        frequencies[nums[right]] += 1
        while frequencies[nums[right]] > k:
            frequencies[nums[left]] -= 1
            left += 1
        result = max(right - left + 1, result)
    return result


if __name__ == "__main__":
    print(maxSubarrayLength([1, 2, 3, 4, 5], 2))
    print(maxSubarrayLength([1, 2, 1, 2, 1], 2))
    print(maxSubarrayLength([1, 2, 1, 3, 4], 3))
