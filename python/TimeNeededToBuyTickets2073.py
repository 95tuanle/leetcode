# There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n -
# 1)th person is at the back of the line. You are given a 0-indexed integer array tickets of length n where the
# number of tickets that the ith person would like to buy is tickets[i]. Each person takes exactly 1 second to buy a
# ticket. A person can only buy 1 ticket at a time and has to go back to the end of the line (which happens
# instantaneously) in order to buy more tickets. If a person does not have any tickets left to buy, the person will
# leave the line. Return the time taken for the person at position k (0-indexed) to finish buying tickets.
from typing import List


def timeRequiredToBuy(tickets: List[int], k: int) -> int:
    result, k_tickets, i = 0, tickets[k], 0
    while i < k:
        result += min(k_tickets, tickets[i])
        i += 1
    result += k_tickets
    i += 1
    k_tickets -= 1
    while i < len(tickets):
        result += min(k_tickets, tickets[i])
        i += 1
    return result


if __name__ == "__main__":
    print(timeRequiredToBuy([2, 3, 4, 5], 1))  # 7
    print(timeRequiredToBuy([5, 3, 4, 5], 0))  # 5
    print(timeRequiredToBuy([5, 3, 4, 5], 1))  # 3
    print(timeRequiredToBuy([5, 3, 4, 5], 2))  # 4
    print(timeRequiredToBuy([5, 3, 4, 5], 3))  # 5
