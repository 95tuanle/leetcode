# The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
# For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
# Given an array nums, return the sum of all XOR totals for every subset of nums.
# Note: Subsets with the same elements should be counted multiple times.
# An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
from typing import List


def subsetXORSum(nums: List[int]) -> int:
    length = len(nums)

    def depthFirstSearch(i, total):
        if i == length:
            return total
        return depthFirstSearch(i + 1, total ^ nums[i]) + depthFirstSearch(i + 1, total)

    return depthFirstSearch(0, 0)


if __name__ == '__main__':
    print(subsetXORSum([1, 3]))  # 6
    print(subsetXORSum([5, 1, 6]))  # 28
    print(subsetXORSum([3, 4, 5, 6, 7, 8]))  # 480
