class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        ROWS = len(board)
        COLS = len(board[0])
        seen = set()

        def dfs( r, c , i):

            # this means we have passed the index and we have succeeded
            if i == len(word):
                return True

            if r < 0 or c < 0 or r >= ROWS or c >= COLS or board[r][c] != word[i] or (r,c) in seen:
                return False

            seen.add((r,c))
            res = dfs(r+1,c,i+1) or dfs(r-1,c,i+1 ) or dfs(r,c+1,i+1) or dfs(r,c-1,i+1)
            seen.remove((r,c))

            return res


        for x in range(ROWS):
            for y in range(COLS):
                if dfs(x,y,0):
                    return True


        return False
