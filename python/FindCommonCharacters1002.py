# Given a string array words, return an array of all characters that show up in all strings within the words (
# including duplicates). You may return the answer in any order.
from typing import List


def commonChars(words: List[str]) -> List[str]:
    common_character_counts = [0] * 26
    for c in words[0]:
        common_character_counts[ord(c) - ord('a')] += 1
    for word in words[1:]:
        current_character_counts = [0] * 26
        for c in word:
            current_character_counts[ord(c) - ord('a')] += 1
        for i in range(26):
            common_character_counts[i] = min(common_character_counts[i], current_character_counts[i])
    result = []
    for i in range(26):
        for _ in range(common_character_counts[i]):
            result.append(chr(i + ord('a')))
    return result


if __name__ == '__main__':
    print(commonChars(["bella", "label", "roller"]))
    print(commonChars(["cool", "lock", "cook"]))
    print(commonChars(["a", "b", "c"]))
    print(commonChars(["a"]))
    print(commonChars(["a", "a"]))
    print(commonChars(["a", "b"]))
    print(commonChars(["a", "b", "a"]))
    print(commonChars(["a", "b", "a", "b"]))
    print(commonChars(["a", "b", "a", "b", "a"]))
    print(commonChars(["a", "b", "a", "b", "a", "b"]))
    print(commonChars(["a", "b", "a", "b", "a", "b", "a"]))
    print(commonChars(["a", "b", "a", "b", "a", "b", "a", "b"]))
    print(commonChars(["a", "b", "a", "b", "a", "b", "a", "b", "a"]))
    print(commonChars(["a", "b", "a", "b", "a", "b", "a", "b", "a", "b"]))
    print(commonChars(["a", "b", "a", "b", "a", "b", "a", "b", "a", "b", "a"]))
    print(commonChars(["a", "b", "a", "b", "a", "b", "a", "b", "a", "b", "a", "b"]))
    print(commonChars(["a", "b", "a", "b", "a", "b", "a", "b", "a", "b", "a", "b", "a"]))
