# You are given a 0-indexed integer array nums and a positive integer k. You can apply the following operation on the
# array any number of times: Choose any element of the array and flip a bit in its binary representation. Flipping a
# bit means changing a 0 to 1 or vice versa. Return the minimum number of operations required to make the bitwise XOR
# of all elements of the final array equal to k. Note that you can flip leading zero bits in the binary
# representation of elements. For example, for the number (101)2 you can flip the fourth bit and obtain (1101)2.
from typing import List


def minOperations(nums: List[int], k: int) -> int:
    result, final_xor = 0, 0
    for num in nums:
        final_xor ^= num
    while k > 0 or final_xor > 0:
        if k % 2 != final_xor % 2:
            result += 1
        k //= 2
        final_xor //= 2
    return result


if __name__ == '__main__':
    print(minOperations([1, 2, 3, 4], 11))
    print(minOperations([2, 4, 6, 8], 5))
    print(minOperations([5, 2, 1, 3], 8))
    print(minOperations([5, 2, 1, 3], 10))
    print(minOperations([5, 2, 1, 3], 0))
    print(minOperations([5, 2, 1, 3], 1))
    print(minOperations([5, 2, 1, 3], 2))
    print(minOperations([5, 2, 1, 3], 3))
    print(minOperations([5, 2, 1, 3], 4))
    print(minOperations([5, 2, 1, 3], 5))
    print(minOperations([5, 2, 1, 3], 6))
    print(minOperations([5, 2, 1, 3], 7))
    print(minOperations([5, 2, 1, 3], 8))
    print(minOperations([5, 2, 1, 3], 9))
    print(minOperations([5, 2, 1, 3], 10))
    print(minOperations([5, 2, 1, 3], 11))
    print(minOperations([5, 2, 1, 3], 12))
    print(minOperations([5, 2, 1, 3], 13))
    print(minOperations([5, 2, 1, 3], 14))
    print(minOperations([5, 2, 1, 3], 15))
    print(minOperations([5, 2, 1, 3], 16))
