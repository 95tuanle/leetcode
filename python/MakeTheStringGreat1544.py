# Given a string s of lower and upper case English letters. A good string is a string which doesn't have two adjacent
# characters s[i] and s[i + 1] where: 0 <= i <= s.length - 2 s[i] is a lower-case letter and s[i + 1] is the same
# letter but in upper-case or vice-versa. To make the string good, you can choose two adjacent characters that make
# the string bad and remove them. You can keep doing this until the string becomes good. Return the string after
# making it good. The answer is guaranteed to be unique under the given constraints. Notice that an empty string is
# also good.
def makeGood(s: str) -> str:
    result = []
    for char in s:
        if result and abs(ord(result[-1]) - ord(char)) == 32:
            result.pop()
        else:
            result.append(char)
    return ''.join(result)


if __name__ == "__main__":
    print(makeGood("leEeetcode"))  # Output: "leetcode"
    print(makeGood("abBAcC"))  # Output: ""
    print(makeGood("s"))  # Output: "s"
    print(makeGood("Pp"))  # Output: ""
