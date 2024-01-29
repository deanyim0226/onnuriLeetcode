class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        
        space complexity is o(n)
        time complexity is o(n^2)
        */
        for(int i = 0; i <board.length; i++){
            
            HashMap<Integer,Integer> rowMap = new HashMap<>();
            HashMap<Integer,Integer> colMap = new HashMap<>();
            HashMap<Integer,Integer> boxMap = new HashMap<>();

            for(int j = 0; j < board[0].length; j++){

                /*
                */
                int r = (i/3) *3 + j/3;   // i/3 *3  (0 3 6)  +  j/3  (0 1 2) 
                int c = (j%3) + (i%3) *3;  // j%3 (0 1 2) + i % 3 * 3  (0 3 6)       
                char boxChar = board[r][c];
          
                if(boxChar != '.'){
                    int box = Character.getNumericValue(boxChar);
                    if(boxMap.containsKey(box)){
                        return false;
                    }else{
                        boxMap.put(box,1);
                    }
                }
                
                char colChar = board[i][j];
                if(colChar != '.'){
                    int col = Character.getNumericValue(colChar);
                    if(rowMap.containsKey(col)){
                       return false;
                    }else{
                        rowMap.put(col,1);
                    }
                 
                }

                char rowChar = board[j][i];
                if(rowChar != '.'){
                    int row = Character.getNumericValue(rowChar);
                    if(colMap.containsKey(row)){
                        return false;
                    }else{
                        colMap.put(row,1);
                    }
                 
                }
                
            }
        }

        return true;
    }
}