# Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
# color are adjacent, with the colors in the order red, white, and blue. We will use the integers 0, 1,
# and 2 to represent the color red, white, and blue, respectively. You must solve this problem without using the
# library's sort function.
from typing import List


def sortColors(nums: List[int]) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    length = len(nums)
    for i in range(length):
        for j in range(length - i - 1):
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]


if __name__ == "__main__":
    nums_outer = [2, 0, 2, 1, 1, 0]
    sortColors(nums_outer)
    print(nums_outer)  # [0, 0, 1, 1, 2, 2]
    nums_outer = [2, 0, 1]
    sortColors(nums_outer)
    print(nums_outer)  # [0, 1, 2]
    nums_outer = [0]
    sortColors(nums_outer)
    print(nums_outer)  # [0]
    nums_outer = [1]
    sortColors(nums_outer)
    print(nums_outer)  # [1]
    nums_outer = [0, 2]
    sortColors(nums_outer)
    print(nums_outer)  # [0, 2]
    nums_outer = [1, 2, 0]
    sortColors(nums_outer)
    print(nums_outer)  # [0, 1, 2]
    nums_outer = [1, 0, 2]
    sortColors(nums_outer)
    print(nums_outer)  # [0, 1, 2]
    nums_outer = [2, 1, 0]
    sortColors(nums_outer)
    print(nums_outer)  # [0, 1, 2]
    nums_outer = [2, 0, 1]
    sortColors(nums_outer)
    print(nums_outer)  # [0, 1, 2]
    nums_outer = [2, 1, 0]
    sortColors(nums_outer)
    print(nums_outer)  # [0, 1, 2]
    nums_outer = [2, 0, 1]
    sortColors(nums_outer)
    print(nums_outer)  # [0, 1, 2]
    nums_outer = [2, 1, 0]
    sortColors(nums_outer)
    print(nums_outer)  # [0, 1, 2]
