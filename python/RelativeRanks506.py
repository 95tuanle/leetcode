# You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
# All the scores are guaranteed to be unique. The athletes are placed based on their scores, where the 1st place
# athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each
# athlete determines their rank: The 1st place athlete's rank is "Gold Medal". The 2nd place athlete's rank is
# "Silver Medal". The 3rd place athlete's rank is "Bronze Medal". For the 4th place to the nth place athlete,
# their rank is their placement number (i.e., the xth place athlete's rank is "x"). Return an array answer of size n
# where answer[i] is the rank of the ith athlete.
from typing import List


def findRelativeRanks(score: List[int]) -> List[str]:
    length = len(score)
    score_dict = {score[i]: i for i in range(length)}
    score.sort(reverse=True)
    result = [""] * length
    for i in range(length):
        if i == 0:
            result[score_dict[score[i]]] = "Gold Medal"
        elif i == 1:
            result[score_dict[score[i]]] = "Silver Medal"
        elif i == 2:
            result[score_dict[score[i]]] = "Bronze Medal"
        else:
            result[score_dict[score[i]]] = str(i + 1)
    return result


if __name__ == "__main__":
    print(findRelativeRanks([5, 4, 3, 2, 1]))
    print(findRelativeRanks([10, 3, 8, 9, 4]))
    print(findRelativeRanks([1, 2, 3, 4, 5]))
    print(findRelativeRanks([1, 3, 2, 4, 5]))
    print(findRelativeRanks([1]))
    print(findRelativeRanks([1, 2]))
    print(findRelativeRanks([2, 1]))
    print(findRelativeRanks([1, 2, 3]))
    print(findRelativeRanks([3, 2, 1]))
    print(findRelativeRanks([1, 2, 3, 4]))
    print(findRelativeRanks([4, 3, 2, 1]))
    print(findRelativeRanks([1, 2, 3, 4, 5]))
    print(findRelativeRanks([5, 4, 3, 2, 1]))
    print(findRelativeRanks([1, 2, 3, 4, 5, 6]))
    print(findRelativeRanks([6, 5, 4, 3, 2, 1]))
