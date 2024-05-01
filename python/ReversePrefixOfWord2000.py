# Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at
# the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing. For
# example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (
# inclusive). The resulting string will be "dcbaefd". Return the resulting string.
def reversePrefix(word: str, ch: str) -> str:
    for i in range(len(word)):
        if word[i] == ch:
            return word[i::-1] + word[i + 1:]
    return word


if __name__ == '__main__':
    print(reversePrefix("abcdefd", "d"))
    print(reversePrefix("xyxzxe", "z"))
    print(reversePrefix("abcd", "z"))
    print(reversePrefix("ab", "z"))
    print(reversePrefix("a", "a"))
    print(reversePrefix("a", "b"))
    print(reversePrefix("a", "c"))
    print(reversePrefix("a", "d"))
    print(reversePrefix("a", "e"))
    print(reversePrefix("a", "f"))
    print(reversePrefix("a", "g"))
    print(reversePrefix("a", "h"))
    print(reversePrefix("a", "i"))
    print(reversePrefix("a", "j"))
    print(reversePrefix("a", "k"))
    print(reversePrefix("a", "l"))
    print(reversePrefix("a", "m"))
    print(reversePrefix("a", "n"))
    print(reversePrefix("a", "o"))
    print(reversePrefix("a", "p"))
    print(reversePrefix("a", "q"))
    print(reversePrefix("a", "r"))
    print(reversePrefix("a", "s"))
    print(reversePrefix("a", "t"))
    print(reversePrefix("a", "u"))
    print(reversePrefix("a", "v"))
    print(reversePrefix("a", "w"))
    print(reversePrefix("a", "x"))
    print(reversePrefix("a", "y"))
    print(reversePrefix("a", "z"))
    print(reversePrefix("a", "A"))
    print(reversePrefix("a", "B"))
    print(reversePrefix("a", "C"))
