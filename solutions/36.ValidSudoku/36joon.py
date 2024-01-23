from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:


        ROWS = 9
        COLS = 9

        columns_set = [ set() for i in range(COLS)]
        rows_set = [ set() for i in range(ROWS)]

        set_for_three_by_three = [ [set() for x in range(3)] for y in range(3) ]


        for i in range(ROWS):
            for j in range(COLS):

                current_char = board[i][j]

                # if it is a dot, ignore
                if current_char == '.':
                    continue

                # check row validity
                if current_char in rows_set[i]:
                    return False

                # check col validity
                if current_char in columns_set[j]:
                    return False

                # check three by three validity

                new_i , new_j = i //3 , j //3

                if current_char in set_for_three_by_three[new_i][new_j]:
                    return False

                # if everything passes, we can add it to its corresponding set, all 3
                rows_set[i].add(current_char)
                columns_set[j].add(current_char)
                set_for_three_by_three[new_i][new_j].add(current_char)

        return True

board1 = [["5","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]

board2 = [["8","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]


solution = Solution()
print(solution.isValidSudoku(board1))
print(solution.isValidSudoku(board2))


