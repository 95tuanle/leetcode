# Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer
# appears once or twice, return an array of all the integers that appears twice. You must write an algorithm that
# runs in O(n) time and uses only constant extra space.
from typing import List


def findDuplicates(nums: List[int]) -> List[int]:
    result = []
    for num in nums:
        new_num = abs(num)
        if nums[new_num - 1] < 0:
            result.append(new_num)
        else:
            nums[new_num - 1] = -nums[new_num - 1]
    return result


if __name__ == "__main__":
    print(findDuplicates([4, 3, 2, 7, 8, 2, 3, 1]))
    print(findDuplicates([1, 1, 2]))
    print(findDuplicates([2, 2, 2, 2, 2]))
    print(findDuplicates([2, 5, 9, 6, 9, 3, 8, 9, 7, 1]))
    print(findDuplicates([1, 3, 4, 2, 2]))
    print(findDuplicates([3, 1, 3, 4, 2]))
    print(findDuplicates([1, 1]))
    print(findDuplicates([1, 1, 2]))
    print(findDuplicates([2, 2, 2, 2, 2]))
    print(findDuplicates([2, 5, 9, 6, 9, 3, 8, 9, 7, 1]))
