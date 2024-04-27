# In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom
# Trail Ring" and use the dial to spell a specific keyword to open the door. Given a string ring that represents the
# code engraved on the outer ring and another string key that represents the keyword that needs to be spelled,
# return the minimum number of steps to spell all the characters in the keyword. Initially, the first character of
# the ring is aligned at the "12:00" direction. You should spell all the characters in key one by one by rotating
# ring clockwise or anticlockwise to make each character of the string key aligned at the "12:00" direction and then
# by pressing the center button. At the stage of rotating the ring to spell the key character key[i]: You can rotate
# the ring clockwise or anticlockwise by one place, which counts as one step. The final purpose of the rotation is to
# align one of ring's characters at the "12:00" direction, where this character must equal key[i]. If the character
# key[i] has been aligned at the "12:00" direction, press the center button to spell, which also counts as one step.
# After the pressing, you could begin to spell the next character in the key (next stage). Otherwise,
# you have finished all the spelling.
import sys
from collections import defaultdict


def findRotateSteps(ring: str, key: str) -> int:
    ring_length = len(ring)
    dp = [0] * ring_length
    positions = defaultdict(list)
    for k, v in enumerate(ring):
        positions[v].append(k)
    for character in reversed(key):
        current = [sys.maxsize] * ring_length
        for position in positions[character]:
            for j in range(ring_length):
                steps_between = abs(j - position)
                current[j] = min(current[j], dp[position] + 1 + min(steps_between, ring_length - steps_between))
        dp = current.copy()
    return dp[0]

    # ring_length = len(ring)
    # dp = [0] * ring_length
    # for character in reversed(key):
    #     current = [sys.maxsize] * ring_length
    #     for i in range(ring_length):
    #         for key, value in enumerate(ring):
    #             if value == character:
    #                 steps_between = abs(key - i)
    #                 current[i] = min(current[i], dp[key] + 1 + min(steps_between, ring_length - steps_between))
    #     dp = current.copy()
    # return dp[0]


if __name__ == '__main__':
    print(findRotateSteps("godding", "gd"))
    print(findRotateSteps("godding", "godding"))
    print(findRotateSteps("godding", "god"))
