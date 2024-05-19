# There exists an undirected tree with n nodes numbered 0 to n - 1. You are given a 0-indexed 2D integer array edges
# of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the tree. You
# are also given a positive integer k, and a 0-indexed array of non-negative integers nums of length n, where nums[i]
# represents the value of the node numbered i. Alice wants the sum of values of tree nodes to be maximum,
# for which Alice can perform the following operation any number of times (including zero) on the tree: Choose any
# edge [u, v] connecting the nodes u and v, and update their values as follows: nums[u] = nums[u] XOR k nums[v] =
# nums[v] XOR k Return the maximum possible sum of the values Alice can achieve by performing the operation any
# number of times.
from typing import List


def maximumValueSum(nums: List[int], k: int, edges: List[List[int]]) -> int:
    length, result = len(nums), 0
    delta = [0] * length
    for i, v in enumerate(nums):
        delta[i] = (v ^ k) - v
        result += v
    delta.sort()
    for i in range(length - 1, 0, -2):
        path_delta = delta[i] + delta[i - 1]
        if path_delta <= 0:
            break
        result += path_delta
    return result


if __name__ == '__main__':
    print(maximumValueSum([1, 2, 3, 4, 5], 3, [[0, 1], [0, 2], [0, 3], [0, 4]]))
    print(maximumValueSum([1, 2, 3, 4, 5], 2, [[0, 1], [0, 2], [0, 3], [0, 4]]))
    print(maximumValueSum([1, 2, 3, 4, 5], 1, [[0, 1], [0, 2], [0, 3], [0, 4]]))
    print(maximumValueSum([1, 2, 3, 4, 5], 0, [[0, 1], [0, 2], [0, 3], [0, 4]]))
    print(maximumValueSum([1, 2, 3, 4, 5], 0, [[0, 1], [1, 2], [2, 3], [3, 4]]))
    print(maximumValueSum([1, 2, 3, 4, 5], 0, [[0, 1], [1, 2], [2, 3], [2, 4]]))
    print(maximumValueSum([1, 2, 3, 4, 5], 0, [[0, 1], [1, 2], [2, 3], [3, 4]]))
    print(maximumValueSum([1, 2, 3, 4, 5], 0, [[0, 1], [1, 2], [2, 3], [4, 3]]))
    print(maximumValueSum([1, 2, 3, 4, 5], 0, [[0, 1], [1, 2], [2, 3], [4, 2]]))
    print(maximumValueSum([1, 2, 3, 4, 5], 0, [[0, 1], [1, 2], [2, 3], [4, 1]]))
