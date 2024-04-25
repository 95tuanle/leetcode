# You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the
# following conditions are satisfied: t is a subsequence of the string s. The absolute difference in the alphabet
# order of every two adjacent letters in t is less than or equal to k. Return the length of the longest ideal string.
# A subsequence is a string that can be derived from another string by deleting some or no characters without
# changing the order of the remaining characters. Note that the alphabet order is not cyclic. For example,
# the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.
def longestIdealString(s: str, k: int) -> int:
    result, dp, first = 0, [0] * 26, ord('a')
    for character in s:
        current, longest, i = ord(character) - first, 0, 0
        while i < current:
            if current - i <= k:
                longest = max(longest, dp[i])
            i += 1
        while i < 26:
            if i - current <= k:
                longest = max(longest, dp[i])
            i += 1
        dp[current] = max(dp[current], longest + 1)
        result = max(result, dp[current])
    return result


if __name__ == '__main__':
    print(longestIdealString('abcde', 0))  # 5
    print(longestIdealString('abcde', 1))  # 5
    print(longestIdealString('abcde', 2))  # 5
    print(longestIdealString('abcde', 3))  # 5
    print(longestIdealString('abcde', 4))  # 5
    print(longestIdealString('abcde', 5))  # 5
    print(longestIdealString('abcde', 6))  # 5
    print(longestIdealString('abcde', 7))  # 5
    print(longestIdealString('abcde', 8))  # 5
    print(longestIdealString('abcde', 9))  # 5
    print(longestIdealString('abcde', 10))  # 5
    print(longestIdealString('abcde', 11))  # 5
    print(longestIdealString('abcde', 12))  # 5
    print(longestIdealString('abcde', 13))  # 5
    print(longestIdealString('abcde', 14))  # 5
    print(longestIdealString('abcde', 15))  # 5
    print(longestIdealString('abcde', 16))  # 5
    print(longestIdealString('abcde', 17))  # 5
    print(longestIdealString('abcde', 18))  # 5
    print(longestIdealString('abcde', 19))  # 5
    print(longestIdealString('abcde', 20))  # 5
    print(longestIdealString('abcde', 21))  # 5
    print(longestIdealString('abcde', 22))  # 5
    print(longestIdealString('abcde', 23))  # 5
    print(longestIdealString('abcde', 24))  # 5
    print(longestIdealString('abcde', 25))  # 5
    print(longestIdealString('abcde', 26))  # 5
    print(longestIdealString('abcde', 27))  # 5
