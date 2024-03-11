# A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
# non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and
# numbers. Given a string s, return true if it is a palindrome, or false otherwise.

def is_palindrome(s: str) -> bool:
    s = "".join(e for e in s if e.isalnum()).lower()
    return s == s[::-1]

    # left, right = 0, len(s) - 1
    # while left <= right:
    #     if not s[left].isalnum():
    #         left += 1
    #     elif not s[right].isalnum():
    #         right -= 1
    #     elif s[left].lower() != s[right].lower():
    #         return False
    #     else:
    #         left += 1
    #         right -= 1
    # return True


if __name__ == '__main__':
    print(is_palindrome('A man, a plan, a canal: Panama'))
    print(is_palindrome('race a car'))
    print(is_palindrome(' '))
