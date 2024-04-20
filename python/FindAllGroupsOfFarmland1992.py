# You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1
# represents a hectare of farmland. To keep the land organized, there are designated rectangular areas of hectares
# that consist entirely of farmland. These rectangular areas are called groups. No two groups are adjacent,
# meaning farmland in one group is not four-directionally adjacent to another farmland in a different group. land can
# be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of
# land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland. A group
# of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length
# array [r1, c1, r2, c2]. Return a 2D array containing the 4-length arrays described above for each group of farmland
# in land. If there are no groups of farmland, return an empty array. You may return the answer in any order.
from typing import List


def findFarmland(land: List[List[int]]) -> List[List[int]]:
    result, rows, columns = [], len(land), len(land[0])
    for i in range(rows):
        for j in range(columns):
            if land[i][j] == 1:
                x, y = i, j
                while x < rows and land[x][j] == 1:
                    y = j
                    while y < columns and land[x][y] == 1:
                        land[x][y] = 0
                        y += 1
                    x += 1
                result.append([i, j, x - 1, y - 1])
    return result


if __name__ == '__main__':
    print(findFarmland([[1, 0, 0], [0, 1, 1], [0, 1, 1]]))  # [[0, 0, 0, 0], [1, 1, 2, 2]]
    print(findFarmland([[1, 1], [1, 1]]))  # [[0, 0, 1, 1]]
    print(findFarmland([[0]]))  # []
    print(findFarmland([[1, 0], [0, 1]]))  # [[0, 0, 0, 0], [1, 1, 1, 1]]
    print(findFarmland([[1, 0, 1], [1, 0, 1]]))  # [[0, 0, 0, 0], [1, 0, 1, 0]]
    print(findFarmland([[1, 1, 1], [1, 0, 1], [1, 1, 1]]))  # [[0, 0, 0, 2], [1, 0, 1, 0], [1, 2, 1, 2]]
    print(findFarmland([[1, 1, 1], [1, 1, 1], [1, 1, 1]]))  # [[0, 0, 2, 2]]
    print(findFarmland([[1, 1, 1], [1, 0, 1], [1, 0, 1]]))  # [[0, 0, 0, 2], [1, 0, 1, 0], [2, 0, 2, 0]]
    print(findFarmland([[1, 1, 1], [1, 0, 0], [1, 0, 1]]))  # [[0, 0, 0, 2], [2, 0, 2, 0]]
    print(findFarmland([[1, 1, 1], [1, 0, 0], [1, 0, 0]]))  # [[0, 0, 0, 2], [2, 0, 2, 0]]
