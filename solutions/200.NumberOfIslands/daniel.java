class Solution {

    public void dfs(char[][]grid, int row, int col){

        if(grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        if(row + 1 <= grid.length-1){
            dfs(grid,row+1,col);
        }

        if(row - 1 >= 0){
            dfs(grid,row-1,col);
        }

        if(col + 1 <= grid[0].length-1){
            dfs(grid,row,col+1);
        }

        if(col - 1 >= 0){
            dfs(grid,row,col-1);
        }
    }

    public int numIslands(char[][] grid) {
        int numOfIsland = 0;

        for(int i =0; i< grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    numOfIsland++;
                }
            }
        }

        return numOfIsland;
    }
}