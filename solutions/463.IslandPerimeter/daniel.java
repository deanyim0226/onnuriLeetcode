class Solution {
    public int islandPerimeter(int[][] grid) {
        /*
        check whether each cell is connected to the water or boundary of grid
        we add 1 otherwise don't need to add 1

        iterate 2d array, and check horizontally/vertically 
        add calculate the perimeter
        */

        int perimeter = 0;
        
        for(int i =0; i <grid.length; i++){
            for(int j= 0; j < grid[0].length; j++){

                if(grid[i][j] == 1){

                    if(i-1 < 0 || grid[i-1][j] == 0){
                        perimeter += 1;
                    }

                    if(j-1 < 0 || grid[i][j-1] == 0){
                        perimeter += 1;
                    }
                    if(i+1 > grid.length-1 || grid[i+1][j] == 0){
                        perimeter += 1;
                    }
        
                    if(j+1 > grid[0].length-1 || grid[i][j+1] == 0){
                        perimeter += 1;
                    }
          
                }
            }
        }

        return perimeter;
    }
}