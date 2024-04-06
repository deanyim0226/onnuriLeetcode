class Solution {

    boolean seen[][];

    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;

        int row = grid.length;
        int col = grid[0].length;

        seen = new boolean[row][col];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                max_area = Math.max(max_area, area(i, j, grid));
            }
        }

        return max_area;
    }

    public int area(int i, int j, int[][] grid)
    {
        if(i < 0 || i >= grid.length || j < 0 || j == grid[i].length || seen[i][j] || grid[i][j] == 0)
            return 0;

        seen[i][j] = true;

        return (1 + area(i + 1, j, grid) + area(i-1, j, grid) + area(i, j-1, grid) + area(i, j+1, grid));
    }
}