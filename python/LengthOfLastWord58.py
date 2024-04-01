# Given a string s consisting of words and spaces, return the length of the last word in the string.
# A word is a maximal substring consisting of non-space characters only.
def lengthOfLastWord(s: str) -> int:
    result = 0
    for i in range(len(s) - 1, -1, -1):
        if s[i] != ' ':
            result += 1
        elif result > 0:
            break
    return result


if __name__ == "__main__":
    print(lengthOfLastWord("Hello World"))  # 5
    print(lengthOfLastWord("   fly me   to   the moon  "))  # 4
    print(lengthOfLastWord("luffy is still joyboy"))  # 6
