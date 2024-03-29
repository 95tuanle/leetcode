# You are given an integer array nums and a positive integer k.
# Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
# A subarray is a contiguous sequence of elements within an array.
from typing import List


def countSubarrays(nums: List[int], k: int) -> int:
    result, highest, counter, left = 0, 1, 0, 0
    for num in nums:
        highest = max(num, highest)
    for right in range(len(nums)):
        if nums[right] == highest:
            counter += 1
        while counter == k and left <= right:
            if nums[left] == highest:
                counter -= 1
            left += 1
        result += left
    return result


if __name__ == "__main__":
    print(countSubarrays([1, 2, 1, 2, 3], 2))  # 7
    print(countSubarrays([1, 4, 1, 4, 1, 4], 3))  # 0
    print(countSubarrays([1, 4, 1, 4, 1, 4], 2))  # 10
    print(countSubarrays([1, 4, 1, 4, 1, 4], 1))  # 21
    print(countSubarrays([1, 4, 1, 4, 1, 4], 4))  # 3
    print(countSubarrays([1, 4, 1, 4, 1, 4], 5))  # 0
    print(countSubarrays([1, 4, 1, 4, 1, 4], 6))  # 0
    print(countSubarrays([1, 4, 1, 4, 1, 4], 7))  # 0
    print(countSubarrays([1, 4, 1, 4, 1, 4], 8))  # 0
    print(countSubarrays([1, 4, 1, 4, 1, 4], 9))  # 0
    print(countSubarrays([1, 4, 1, 4, 1, 4], 10))  # 0
    print(countSubarrays([1, 4, 1, 4, 1, 4], 11))  # 0
    print(countSubarrays([1, 4, 1, 4, 1, 4], 12))  # 0
    print(countSubarrays([1, 4, 1, 4, 1, 4], 13))  # 0
    print(countSubarrays([1, 4, 1, 4, 1, 4], 14))  # 0
    print(countSubarrays([1, 4, 1, 4, 1, 4], 15))  # 0
