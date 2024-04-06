# Given a string s of '(' , ')' and lowercase English characters. Your task is to remove the minimum number of
# parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid
# string. Formally, a parentheses string is valid if and only if: It is the empty string, contains only lowercase
# characters, or It can be written as AB (A concatenated with B), where A and B are valid strings, or It can be
# written as (A), where A is a valid string.
def minRemoveToMakeValid(s: str) -> str:
    result, count = [], 0
    for c in s:
        if c == '(':
            result.append(c)
            count += 1
        elif c != ')':
            result.append(c)
        elif count > 0:
            result.append(c)
            count -= 1

    i = len(result) - 1
    while count > 0:
        if result[i] == '(':
            result[i] = ''
            count -= 1
        i -= 1

    return ''.join(result)


if __name__ == "__main__":
    print(minRemoveToMakeValid("lee(t(c)o)de)"))  # "lee(t(c)o)de"
    print(minRemoveToMakeValid("a)b(c)d"))  # "ab(c)d"
    print(minRemoveToMakeValid("))(("))  # ""
    print(minRemoveToMakeValid("(a(b(c)d)"))  # "a(b(c)d)
