# Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
# represent. Return the answer in any order. A mapping of digits to letters (just like on the telephone buttons) is
# given below. Note that 1 does not map to any letters.
from typing import List


def letterCombinations(digits: str) -> List[str]:
    result = []
    phone = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}

    def backtrack(i, string):
        if len(string) == len(digits):
            result.append(string)
        else:
            for char in phone[digits[i]]:
                backtrack(i + 1, string + char)

    if digits:
        backtrack(0, "")
    return result


if __name__ == "__main__":
    print(letterCombinations("23"))
    print(letterCombinations(""))
    print(letterCombinations("2"))
    print(letterCombinations("234"))
    print(letterCombinations("2345"))
    print(letterCombinations("23456"))
    print(letterCombinations("234567"))
    print(letterCombinations("2345678"))
    print(letterCombinations("23456789"))
