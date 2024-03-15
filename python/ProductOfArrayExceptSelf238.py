# Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
# of nums except nums[i]. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer. You
# must write an algorithm that runs in O(n) time and without using the division operation
from typing import List


def product_except_self(nums: List[int]) -> List[int]:
    result, product = [], 1
    for num in nums:
        result.append(product)
        product *= num
    product = 1
    for i in range(len(nums) - 1, -1, -1):
        result[i] *= product
        product *= nums[i]
    return result


if __name__ == "__main__":
    print(product_except_self([1, 2, 3, 4]))
    print(product_except_self([-1, 1, 0, -3, 3]))
    print(product_except_self([1, 2, 3, 4, 5]))
    print(product_except_self([1, 2, 3, 4, 5, 6]))
    print(product_except_self([1, 2, 3, 4, 5, 6, 7]))
    print(product_except_self([1, 2, 3, 4, 5, 6, 7, 8]))
    print(product_except_self([1, 2, 3, 4, 5, 6, 7, 8, 9]))
    print(product_except_self([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
    print(product_except_self([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]))
    print(product_except_self([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]))
    print(product_except_self([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]))
    print(product_except_self([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]))
    print(product_except_self([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]))
    print(product_except_self([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]))
