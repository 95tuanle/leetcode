# You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6',
# '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be
# '9'. Each move consists of turning one wheel one slot. The lock initially starts at '0000', a string representing
# the state of the 4 wheels. You are given a list of deadends dead ends, meaning if the lock displays any of these
# codes, the wheels of the lock will stop turning and you will be unable to open it. Given a target representing the
# value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock,
# or -1 if it is impossible.
from collections import deque
from typing import List


def openLock(deadends: List[str], target: str) -> int:
    visited = set(deadends)
    if "0000" in visited:
        return -1
    queue = deque()
    queue.append("0000")
    visited.add("0000")
    depth = 0
    while queue:
        breath_size = len(queue)
        for i in range(breath_size):
            combination = queue.popleft()
            if combination == target:
                return depth
            for j in range(4):
                for k in [-1, 1]:
                    new_combination = combination[:j] + str((int(combination[j]) + k) % 10) + combination[j + 1:]
                    if new_combination not in visited:
                        visited.add(new_combination)
                        queue.append(new_combination)
        depth += 1
    return -1


if __name__ == '__main__':
    print(openLock(["0201", "0101", "0102", "1212", "2002"], "0202"))  # 6
    print(openLock(["8888"], "0009"))  # 1
    print(openLock(["8888"], "0000"))  # 0
    print(openLock(["0000"], "8888"))  # -1
    print(openLock(["0000", "0001", "0009"], "8888"))  # -1
    print(openLock(["0000", "0001", "0009"], "0008"))  # 4
    print(openLock(["0000", "0001", "0009"], "0007"))  # 3
    print(openLock(["0000", "0001", "0009"], "0006"))  # 2
    print(openLock(["0000", "0001", "0009"], "0005"))  # 1
    print(openLock(["0000", "0001", "0009"], "0004"))  # 2
    print(openLock(["0000", "0001", "0009"], "0003"))  # 3
    print(openLock(["0000", "0001", "0009"], "0002"))  # 4
    print(openLock(["0000", "0001", "0009"], "0001"))  # 1
    print(openLock(["0000", "0001", "0009"], "0000"))  # 0
    print(openLock(["0000", "0001", "0009"], "9999"))  # -1
    print(openLock(["0000", "0001", "0009"], "9998"))  # -1
    print(openLock(["0000", "0001", "0009"], "9997"))  # -1
    print(openLock(["0000", "0001", "0009"], "9996"))  # -1
    print(openLock(["0000", "0001", "0009"], "9995"))  # -1
    print(openLock(["0000", "0001", "0009"], "9994"))  # -1
