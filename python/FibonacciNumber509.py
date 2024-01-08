# The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number
# is the sum of the two preceding ones, starting from 0 and 1. That is, F(0) = 0, F(1) = 1 F(n) = F(n - 1) + F(n -
# 2), for n > 1. Given n, calculate F(n).

# def fib(self, n: int) -> int:
#     if n == 0:
#         return 0
#     if n == 1:
#         return 1
#     return self.fib(n - 1) + self.fib(n - 2)


# def fib(self, n: int, cache=None) -> int:
#     if n == 0:
#         return 0
#     if n == 1:
#         return 1
#     if cache is None:
#         cache = {}
#     if n in cache:
#         return cache[n]
#     result = self.fib(n - 1, cache) + self.fib(n - 2, cache)
#     cache[n] = result
#     return result


def fib(self, n: int) -> int:
    a, b = 0, 1
    for _ in range(2, n + 2):
        a, b = b, a + b
    return a


if __name__ == '__main__':
    print(fib(None, 2))
    print(fib(None, 3))
    print(fib(None, 4))
