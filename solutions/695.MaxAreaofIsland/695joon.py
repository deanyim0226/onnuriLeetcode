class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:


        ROWS = len(grid)
        COLS = len(grid[0])
        been_here_or_not = set()
        max_area = 0

        def dfs(x,y,been_here_or_not):

            #base case

            if ( (x,y) in been_here_or_not ) or x<0 or x >= ROWS or y<0 or y >= COLS or grid[x][y] == 0:
                return 0

            else:

                been_here_or_not.add((x,y))

                area_here =  1 + dfs(x+1,y,been_here_or_not) + dfs(x-1,y,been_here_or_not) + dfs(x,y+1,been_here_or_not) + dfs(x,y-1,been_here_or_not)


                return area_here

        been_here_or_not = set()

        for i in range(ROWS):
            for j in range(COLS):

                if grid[i][j] == 1:
                    max_area = max( dfs(i,j,been_here_or_not) , max_area)


        return max_area
