# Given an integer array nums and an integer k, return the number of good subarrays of nums.
# A good array is an array where the number of different integers in that array is exactly k.
# For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
# A subarray is a contiguous part of an array.
from collections import defaultdict
from typing import List


def subarraysWithKDistinct(nums: List[int], k: int) -> int:
    result, near, far = 0, 0, 0
    frequencies = defaultdict(int)
    for num in nums:
        frequencies[num] += 1
        while len(frequencies) > k:
            frequencies[nums[near]] -= 1
            if frequencies[nums[near]] == 0:
                frequencies.pop(nums[near])
            near += 1
            far = near
        while near < len(nums) and frequencies[nums[near]] > 1:
            frequencies[nums[near]] -= 1
            near += 1
        if len(frequencies) == k:
            result += near - far + 1
    return result


if __name__ == "__main__":
    nums_outer = [1, 2, 1, 2, 3]
    k_outer = 2
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 7
    nums_outer = [1, 2, 1, 3, 4]
    k_outer = 3
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 3
    nums_outer = [1, 2, 1, 2, 3]
    k_outer = 3
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 2
    nums_outer = [1, 2, 1, 2, 3]
    k_outer = 4
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 0
    nums_outer = [1, 2, 1, 2, 3]
    k_outer = 1
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 0
    nums_outer = [1, 2, 1, 2, 3]
    k_outer = 5
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 0
    nums_outer = [1, 2, 1, 2, 3]
    k_outer = 0
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 0
    nums_outer = [1, 2, 1, 2, 3]
    k_outer = 6
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 0
    nums_outer = [1, 2, 1, 2, 3]
    k_outer = 7
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 0
    nums_outer = [1, 2, 1, 2, 3]
    k_outer = 8
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 0
    nums_outer = [1, 2, 1, 2, 3]
    k_outer = 9
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 0
    nums_outer = [1, 2, 1, 2, 3]
    k_outer = 10
    print(subarraysWithKDistinct(nums_outer, k_outer))  # Output 0
