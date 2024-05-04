# You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats
# where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time,
# provided the sum of the weight of those people is at most limit. Return the minimum number of boats to carry every
# given person.
from typing import List


def numRescueBoats(people: List[int], limit: int) -> int:
    people.sort()
    result, left, right = 0, 0, len(people)
    while left < right:
        result += 1
        right -= 1
        if limit - people[right] >= people[left]:
            left += 1
    return result


if __name__ == '__main__':
    print(numRescueBoats([1, 2], 3))  # 1
    print(numRescueBoats([3, 2, 2, 1], 3))  # 3
    print(numRescueBoats([3, 5, 3, 4], 5))  # 4
    print(numRescueBoats([3, 5, 3, 4], 6))  # 3
    print(numRescueBoats([3, 5, 3, 4], 7))  # 3
    print(numRescueBoats([3, 5, 3, 4], 8))  # 2
    print(numRescueBoats([3, 5, 3, 4], 9))  # 2
    print(numRescueBoats([3, 5, 3, 4], 10))  # 2
    print(numRescueBoats([3, 5, 3, 4], 11))  # 2
    print(numRescueBoats([3, 5, 3, 4], 12))  # 2
    print(numRescueBoats([3, 5, 3, 4], 13))  # 2
    print(numRescueBoats([3, 5, 3, 4], 14))  # 2
    print(numRescueBoats([3, 5, 3, 4], 15))  # 2
    print(numRescueBoats([3, 5, 3, 4], 16))  # 2
    print(numRescueBoats([3, 5, 3, 4], 17))  # 2
    print(numRescueBoats([3, 5, 3, 4], 18))  # 2
    print(numRescueBoats([3, 5, 3, 4], 19))  # 2
    print(numRescueBoats([3, 5, 3, 4], 20))  # 2
    print(numRescueBoats([3, 5, 3, 4], 21))  # 2
