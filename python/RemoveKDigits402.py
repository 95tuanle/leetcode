# Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer
# after removing k digits from num.
def removeKdigits(num: str, k: int) -> str:
    stack = []
    for digit in num:
        while stack and stack[-1] > digit and k > 0:
            k -= 1
            stack.pop()
        stack.append(digit)
    while k > 0:
        k -= 1
        stack.pop()
    return ''.join(stack).lstrip('0') or '0'


if __name__ == "__main__":
    print(removeKdigits("1432219", 3))  # 1219
    print(removeKdigits("10200", 1))  # 200
    print(removeKdigits("10", 2))  # 0
    print(removeKdigits("9", 1))  # 0
    print(removeKdigits("112", 1))  # 11
    print(removeKdigits("1234567890", 9))  # 0
    print(removeKdigits("1234567890", 10))  # 0
