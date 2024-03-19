# You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or
# interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint:
# identical tasks must be separated by at least n intervals due to cooling time. Return the minimum number of
# intervals required to complete all tasks.
from collections import Counter
from typing import List


def leastInterval(tasks: List[str], n: int) -> int:
    task_counts = Counter(tasks)
    max_count = max(task_counts.values())
    max_count_tasks = sum(1 for count in task_counts.values() if count == max_count)
    return max(len(tasks), (max_count - 1) * (n + 1) + max_count_tasks)

    # task_counts = Counter(tasks)
    # pq = PriorityQueue()
    # for count in task_counts.values():
    #     pq.put(-count)
    # time = 0
    # q = deque()
    # while not pq.empty() or len(q) != 0:
    #     time += 1
    #     if not pq.empty():
    #         count = pq.get() + 1
    #         if count < 0:
    #             q.append([count, time + n])
    #     if len(q) != 0 and q[0][1] == time:
    #         pq.put(q.popleft()[0])
    # return time


if __name__ == "__main__":
    print(leastInterval(["A", "A", "A", "B", "B", "B"], 2))  # 8
    print(leastInterval(["A", "A", "A", "B", "B", "B"], 0))  # 6
    print(leastInterval(["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"], 2))  # 16
    print(leastInterval(["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"], 1))  # 12
    print(leastInterval(["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"], 0))  # 12
    print(leastInterval(["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"], 100))  # 104
    print(leastInterval(["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"], 10000))  # 104
    print(leastInterval(["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"], 1000000000))  # 104
