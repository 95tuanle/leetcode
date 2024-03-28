# Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of
# all the elements in the subarray is strictly less than k.
from typing import List


def numSubarrayProductLessThanK(nums: List[int], k: int) -> int:
    counter, product, left = 0, 1, 0
    for right in range(len(nums)):
        product *= nums[right]
        while left <= right and product >= k:
            product //= nums[left]
            left += 1
        counter += right - left + 1
    return counter


if __name__ == "__main__":
    print(numSubarrayProductLessThanK([10, 5, 2, 6], 100))
    print(numSubarrayProductLessThanK([1, 2, 3], 0))
    print(numSubarrayProductLessThanK([1, 1, 1], 1))
    print("The values above should be 8, 0, and 0.")
