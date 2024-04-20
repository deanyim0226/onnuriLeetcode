class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:


        #Initializes sets to keep track of occupied columns and diagonals

        col = set()
        posDiagonal = set() # (r+c)
        negDiagonal = set() # (r-c)

        result = []
        board = [ ["."]*n for i in range(n)]


        def backtrack(r):
            # base case: if all queens are placed (reached last row), append the current board configuration to the result
            if r ==n:
                copy = ["".join(row) for row in board ]
                result.append(copy)
                return

                # iterate through each column

            for c in range(n):
                # check if placing a queen at position (r,c) violates any constraints
                if c in col or (r+c) in posDiagonal or (r-c) in negDiagonal:
                    continue

                    #Update occupied columns and diagonals
                col.add(c)
                posDiagonal.add(r+c)
                negDiagonal.add(r-c)
                board[r][c] = "Q" # place the queen

                # Recursive call to place queens in the next row

                backtrack(r+1)

                #Backtrack: Remove the queen and reset states of occupied columns and diagonals
                col.remove(c)
                posDiagonal.remove(r+c)
                negDiagonal.remove(r-c)
                board[r][c] = "."

        backtrack(0)
        return result