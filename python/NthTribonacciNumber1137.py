# The Tribonacci sequence Tn is defined as follows:
# T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
# Given n, return the value of Tn.
def tribonacci(n: int) -> int:
    if n == 0:
        return 0
    if n == 1 or n == 2:
        return 1
    a, b, c = 0, 1, 1
    for i in range(3, n + 1):
        a, b, c = b, c, a + b + c
    return c


if __name__ == "__main__":
    print(tribonacci(4))  # 4
    print(tribonacci(25))  # 1389537
    print(tribonacci(37))  # 2082876103
    print(tribonacci(38))  # 3416454624
    print(tribonacci(39))  # 5509314687
    print(tribonacci(40))  # 8925768414
    print(tribonacci(41))  # 14485863001
    print(tribonacci(42))  # 23441649015
    print(tribonacci(43))  # 37927512016
    print(tribonacci(44))  # 61358961032
    print(tribonacci(45))  # 99285573049
    print(tribonacci(46))  # 160944983097
    print(tribonacci(47))  # 260230867248
    print(tribonacci(48))  # 420175850344
    print(tribonacci(49))  # 680607717689
    print(tribonacci(50))  # 1101783503033
    print(tribonacci(51))  # 1782386000722
    print(tribonacci(52))  # 2884169503754
    print(tribonacci(53))  # 4666555504476
    print(tribonacci(54))  # 7553115018952
    print(tribonacci(55))  # 12239640532384
    print(tribonacci(56))  # 19892755551312
    print(tribonacci(57))  # 32132396083696
    print(tribonacci(58))  # 52025151635008
    print(tribonacci(59))  # 84257547718704
    print(tribonacci(60))  # 136082599253312
    print(tribonacci(61))  # 220340455111008
    print(tribonacci(62))  # 356423054364320
    print(tribonacci(63))  # 576763509728640
    print(tribonacci(64))  # 933186564092960
