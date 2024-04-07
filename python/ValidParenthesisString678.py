# Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
# The following rules define a valid string:
# Any left parenthesis '(' must have a corresponding right parenthesis ')'.
# Any right parenthesis ')' must have a corresponding left parenthesis '('.
# Left parenthesis '(' must go before the corresponding right parenthesis ')'.
# '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
def checkValidString(s: str) -> bool:
    open_balance, close_balance, length = 0, 0, len(s) - 1
    for i in range(length + 1):
        if s[i] == ')':
            open_balance -= 1
        else:
            open_balance += 1
        if s[length - i] == '(':
            close_balance -= 1
        else:
            close_balance += 1
        if open_balance < 0 or close_balance < 0:
            return False
    return True


if __name__ == "__main__":
    print(checkValidString("()"))  # True
    print(checkValidString("(*)"))  # True
    print(checkValidString("(*))"))  # True
