# Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
from typing import List


def find_max_length(nums: List[int]) -> int:
    count, result = 0, 0
    hash_map = {0: -1}
    for i, v in enumerate(nums):
        count += -1 if v == 0 else 1
        if count not in hash_map:
            hash_map[count] = i
        else:
            result = max(result, i - hash_map[count])
    return result


if __name__ == "__main__":
    print(find_max_length([0, 1]))
    print(find_max_length([0, 1, 0]))
    print(find_max_length([0, 0, 1, 0, 0, 0, 1, 1]))
    print(find_max_length([0, 1, 0, 1]))
