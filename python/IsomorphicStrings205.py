# Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters
# in s can be replaced to get t. All occurrences of a character must be replaced with another character while
# preserving the order of characters. No two characters may map to the same character, but a character may map to
# itself.
def isIsomorphic(s: str, t: str) -> bool:
    s_map, t_map = {}, {}
    for i in range(len(s)):
        s_char, t_char = s[i], t[i]
        if (s_char in s_map and s_map[s_char] != t_char) or (t_char in t_map and t_map[t_char] != s_char):
            return False
        s_map[s_char] = t_char
        t_map[t_char] = s_char
    return True


if __name__ == "__main__":
    print(isIsomorphic("egg", "add"))  # True
    print(isIsomorphic("foo", "bar"))  # False
    print(isIsomorphic("paper", "title"))  # True
    print(isIsomorphic("badc", "baba"))  # False
    print(isIsomorphic("ab", "aa"))  # False
    print(isIsomorphic("ab", "ca"))  # True
