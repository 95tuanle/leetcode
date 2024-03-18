# You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the
# start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an
# interval newInterval = [start, end] that represents the start and end of another interval. Insert newInterval into
# intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any
# overlapping intervals (merge overlapping intervals if necessary). Return intervals after the insertion. Note that
# you don't need to modify intervals in-place. You can make a new array and return it.
from typing import List


def insert(intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
    result = []
    for interval in intervals:
        if not newInterval or interval[1] < newInterval[0]:
            result.append(interval)
        elif interval[0] > newInterval[1]:
            result.append(newInterval)
            result.append(interval)
            newInterval = None
        else:
            newInterval = [min([interval[0], newInterval[0]]), max([interval[1], newInterval[1]])]
    if newInterval:
        result.append(newInterval)
    return result


if __name__ == "__main__":
    print(insert([[1, 3], [6, 9]], [2, 5]))  # [[1,5],[6,9]]
    print(insert([[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], [4, 8]))  # [[1,2],[3,10],[12,16]]
    print(insert([], [5, 7]))  # [[5,7]]
    print(insert([[1, 5]], [2, 3]))  # [[1,5]]
    print(insert([[1, 5]], [2, 7]))  # [[1,7]]
    print(insert([[1, 5]], [6, 8]))  # [[1,5],[6,8]]
    print(insert([[1, 5]], [0, 0]))  # [[0,0],[1,5]]
    print(insert([[1, 5]], [0, 3]))  # [[0,5]]
    print(insert([[1, 5]], [0, 6]))  # [[0,6]]
    print(insert([[1, 5]], [0, 7]))  # [[0,7]]
    print(insert([[1, 5]], [1, 5]))  # [[1,5]]
    print(insert([[1, 5]], [1, 6]))  # [[1,6]]
    print(insert([[1, 5]], [1, 7]))  # [[1,7]]
    print(insert([[1, 5]], [2, 3]))  # [[1,5]]
    print(insert([[1, 5]], [2, 6]))  # [[1,6]]
    print(insert([[1, 5]], [2, 7]))  # [[1,7]]
    print(insert([[1, 5]], [3, 4]))  # [[1,5]]
    print(insert([[1, 5]], [3, 6]))  # [[1,6]]
    print(insert([[1, 5]], [3, 7]))  # [[1,7]]
    print(insert([[1, 5]], [4, 5]))  # [[1,5]]
    print(insert([[1, 5]], [4, 6]))
