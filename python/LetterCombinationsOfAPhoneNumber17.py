from typing import List


def letter_combinations(self, digits: str) -> List[str]:
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
    print(letter_combinations(None, "23"))
    print(letter_combinations(None, ""))
    print(letter_combinations(None, "2"))
    print(letter_combinations(None, "234"))
    print(letter_combinations(None, "2345"))
    print(letter_combinations(None, "23456"))
    print(letter_combinations(None, "234567"))
    print(letter_combinations(None, "2345678"))
    print(letter_combinations(None, "23456789"))
