# You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is deck[i].
# You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
# You will do the following steps repeatedly until all cards are revealed:
# Take the top card of the deck, reveal it, and take it out of the deck.
# If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
# If there are still unrevealed cards, go back to step 1. Otherwise, stop.
# Return an ordering of the deck that would reveal the cards in increasing order.
# Note that the first entry in the answer is considered to be the top of the deck.
from collections import deque
from typing import List


def deckRevealedIncreasing(deck: List[int]) -> List[int]:
    length, queue = len(deck), deque()
    for i in range(length):
        queue.append(i)
    deck.sort()
    result = [0] * length
    for i in deck:
        result[queue.popleft()] = i
        if queue:
            queue.append(queue.popleft())
    return result


if __name__ == "__main__":
    print(deckRevealedIncreasing([17, 13, 11, 2, 3, 5, 7]))  # [2, 13, 3, 11, 5, 17, 7]
    print(deckRevealedIncreasing([1, 2, 3, 4, 5, 6]))  # [1, 3, 2, 5, 4, 6]
    print(deckRevealedIncreasing([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))  # [1, 6, 2, 10, 3, 8, 4, 7, 5, 9]
    print(deckRevealedIncreasing([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]))
    print(deckRevealedIncreasing([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]))
    print(deckRevealedIncreasing([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]))
