# Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to
# search target in nums. If target exists, then return its index. Otherwise, return -1. You must write an algorithm
# with O(log n) runtime complexity.
from typing import List


def search(nums: List[int], target: int) -> int:
    left, right = 0, len(nums) - 1
    while left <= right:
        mid = (right + left) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
    return -1


if __name__ == "__main__":
    print(search([-1, 0, 3, 5, 9, 12], 9))
    print(search([-1, 0, 3, 5, 9, 12], 2))
    print(search([5], 5))
    print(search([5], -5))
    print(search([5], 0))
    print(search([5], 10))
    print(search([5, 10], 5))
    print(search([5, 10], 10))
    print(search([5, 10], 0))
    print(search([5, 10], 15))
    print(search([5, 10, 15], 5))
    print(search([5, 10, 15], 10))
    print(search([5, 10, 15], 15))
    print(search([5, 10, 15], 0))
    print(search([5, 10, 15], 20))
    print(search([5, 10, 15, 20], 5))
    print(search([5, 10, 15, 20], 10))
    print(search([5, 10, 15, 20], 15))
    print(search([5, 10, 15, 20], 20))
    print(search([5, 10, 15, 20], 0))
    print(search([5, 10, 15, 20], 25))
    print(search([5, 10, 15, 20, 25], 5))
    print(search([5, 10, 15, 20, 25], 10))
    print(search([5, 10, 15, 20, 25], 15))
    print(search([5, 10, 15, 20, 25], 20))
    print(search([5, 10, 15, 20, 25], 25))
    print(search([5, 10, 15, 20, 25], 0))
    print(search([5, 10, 15, 20, 25], 30))
    print(search([5, 10, 15, 20, 25, 30], 5))
