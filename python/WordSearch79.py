# Given an m x n grid of characters board and a string word, return true if word exists in the grid. The word can be
# constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically
# neighboring. The same letter cell may not be used more than once.
from typing import List


def exist(board: List[List[str]], word: str) -> bool:
    rows, columns, length = len(board), len(board[0]), len(word)
    visited = [[False] * columns for _ in range(rows)]

    def depth_first_search(i, j, index):
        if index == length:
            return True
        if i < 0 or i >= rows or j < 0 or j >= columns or word[index] != board[i][j] or visited[i][j]:
            return False
        visited[i][j] = True
        index += 1
        if depth_first_search(i + 1, j, index) or depth_first_search(i - 1, j, index) or depth_first_search(i, j + 1,
                                                                                                            index) or depth_first_search(
            i, j - 1, index):
            return True
        visited[i][j] = False
        return False

    first = word[0]
    for i in range(rows):
        for j in range(columns):
            if first == board[i][j] and depth_first_search(i, j, 0):
                return True
    return False


if __name__ == "__main__":
    print(exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "ABCCED"))  # True
    print(exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "SEE"))  # True
    print(exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "ABCB"))  # False
    print(exist([["A", "B", "C", "E"], ["S", "F", "E", "S"], ["A", "D", "E", "E"]], "ABCESEEEFS"))  # True
