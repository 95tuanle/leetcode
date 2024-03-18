# Find all valid combinations of k numbers that sum up to n such that the following conditions are true: Only numbers
# 1 through 9 are used. Each number is used at most once. Return a list of all possible valid combinations. The list
# must not contain the same combination twice, and the combinations may be returned in any order.
from typing import List


def combinationSum3(k: int, n: int) -> List[List[int]]:
    def backtracking(start, current_k, current_n, current):
        if current_k < 0 or current_n < 0:
            return
        if current_k == 0 and current_n == 0:
            result.append(current[:])
        else:
            for i in range(start, 10):
                if i > current_n:
                    break
                current.append(i)
                backtracking(i + 1, current_k - 1, current_n - i, current)
                current.pop()

    result = []
    backtracking(1, k, n, [])
    return result


if __name__ == "__main__":
    print(combinationSum3(3, 7))  # [[1, 2, 4]]
    print(combinationSum3(3, 9))  # [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
    print(combinationSum3(4, 1))  # []
    print(combinationSum3(3, 2))  # []
    print(combinationSum3(9, 45))  # [[1, 2, 3, 4, 5, 6, 7, 8, 9]]
    print(combinationSum3(9, 46))  # []
    print(combinationSum3(9, 47))  # []
    print(combinationSum3(9, 48))  # []
    print(combinationSum3(9, 49))  # []
    print(combinationSum3(9, 50))  # []
    print(combinationSum3(9, 51))  # []
    print(combinationSum3(9, 52))  # []
    print(combinationSum3(9, 53))  # []
    print(combinationSum3(9, 54))  # []
    print(combinationSum3(9, 55))  # []
    print(combinationSum3(9, 56))  # []
    print(combinationSum3(9, 57))  # []
    print(combinationSum3(9, 58))  # []
    print(combinationSum3(9, 59))  # []
    print(combinationSum3(9, 60))  # []
    print(combinationSum3(9, 61))  # []
    print(combinationSum3(9, 62))  # []
    print(combinationSum3(9, 63))  # []
    print(combinationSum3(9, 64))  # []
    print(combinationSum3(9, 65))  # []
    print(combinationSum3(9, 66))  # []
    print(combinationSum3(9, 67))  # []
    print(combinationSum3(9, 68))  # []
    print(combinationSum3(9, 69))  # []
