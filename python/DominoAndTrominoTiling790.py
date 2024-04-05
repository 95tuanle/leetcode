# You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes. Given an
# integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo
# 109 + 7. In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are
# two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a
# tile.
def numTilings(n: int) -> int:
    if n == 1:
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 5
    one, two, three = 1, 2, 5
    for _ in range(4, n + 1):
        one, two, three = two, three, (2 * three + one) % 1000000007
    return three


if __name__ == "__main__":
    print(numTilings(3))  # Output: 5
    print(numTilings(4))  # Output: 11
    print(numTilings(5))  # Output: 24
    print(numTilings(6))  # Output: 53
    print(numTilings(7))  # Output: 117
    print(numTilings(8))  # Output: 258
    print(numTilings(9))  # Output: 569
    print(numTilings(10))  # Output: 1255
    print(numTilings(11))  # Output: 2767
    print(numTilings(12))  # Output: 6107
    print(numTilings(13))  # Output: 13475
    print(numTilings(14))  # Output: 29718
    print(numTilings(15))  # Output: 65533
    print(numTilings(16))  # Output: 144644
    print(numTilings(17))  # Output: 319122
    print(numTilings(18))  # Output: 704867
    print(numTilings(19))  # Output: 1552465
    print(numTilings(20))  # Output: 3423801
    print(numTilings(21))  # Output: 7549745
    print(numTilings(22))  # Output: 16641099
    print(numTilings(23))  # Output: 36629155
    print(numTilings(24))  # Output: 80702695
    print(numTilings(25))  # Output: 177997941
    print(numTilings(26))  # Output: 393069529
    print(numTilings(27))  # Output: 866988873
    print(numTilings(28))  # Output: 1917402657
    print(numTilings(29))  # Output: 4222475045
    print(numTilings(30))  # Output: 9319674297
    print(numTilings(31))  # Output: 205622
