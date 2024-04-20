class Solution {

 
    public int orangesRotting(int[][] grid) {
        
        int minTime = -1;
        int freshOrange = 0;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        Set<Pair<Integer,Integer>> visited = new HashSet<>();
        boolean check = false;
        for(int i =0; i< grid.length; i++){
            for(int j =0; j< grid[0].length; j++){

                if(grid[i][j] == 2){
                    Pair<Integer,Integer> pair = new Pair<>(i,j);
                    queue.add(pair);      
                }
            }
        }

         while(!queue.isEmpty()){
                            
            int size = queue.size();
            for(int k =0; k < size; k++){
                Pair<Integer,Integer> currPosition = queue.poll();
                if(!visited.contains(currPosition)){
                    check = true;
                    visited.add(currPosition);
                    int row = currPosition.getKey();
                    int col = currPosition.getValue();
                    grid[row][col] = 2;
                    if(row+1 < grid.length){
                        if(grid[row+1][col] == 1){
                            Pair<Integer,Integer> newPosition = new Pair<>(row+1,col);
                            queue.add(newPosition);
                   
                        }
                    }
                    if(row-1 > -1){
                        if(grid[row-1][col] == 1){
                            Pair<Integer,Integer> newPosition = new Pair<>(row-1,col);
                            queue.add(newPosition);
                 
                        }
                    }

                    if(col+1 < grid[0].length){
                        if(grid[row][col+1] == 1){
                            Pair<Integer,Integer> newPosition = new Pair<>(row,col+1);
                            queue.add(newPosition);
              
                        }
                    }

                    if(col-1 > -1){
                        if(grid[row][col-1] == 1){
                            Pair<Integer,Integer> newPosition = new Pair<>(row,col-1);
                            queue.add(newPosition);
                       
                        }
                    }
                }
                
            }

            if(check){
                minTime += 1;  
                check = false;
            }
                                    
        }

        for(int i =0; i < grid.length; i ++){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return minTime == -1 ?  0 : minTime;
   }
}