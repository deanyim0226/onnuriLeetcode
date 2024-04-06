class Solution {
    private int maxArea = 0;
    private int currArea = 0;

    public void dfs(int[][] grid, int row, int col){

        if(grid[row][col] == 0){
            return;
        }

        grid[row][col] = 0;
        currArea += 1;

        if(row - 1 >= 0){
            dfs(grid, row-1, col);
        }

        if(row + 1 <= grid.length-1){
            dfs(grid, row+1, col);
        }

        if(col - 1 >= 0){
            dfs(grid, row, col-1);
        }

        if(col + 1 <= grid[0].length-1 ){
            dfs(grid,row,col+1);
        }

    }
    public int maxAreaOfIsland(int[][] grid) {
        
        for(int i =0; i < grid.length; i++){
            for(int j =0; j < grid[i].length; j++){

                if(grid[i][j] == 1){

                    dfs(grid,i,j);
                    maxArea = Math.max(maxArea,currArea);
                }
                currArea = 0;
            }
        }

        return maxArea;
    }
}