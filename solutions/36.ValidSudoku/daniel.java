class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i <board.length; i++){
            
            HashMap<Integer,Integer> rowMap = new HashMap<>();
            HashMap<Integer,Integer> colMap = new HashMap<>();
            HashMap<Integer,Integer> boxMap = new HashMap<>();

            for(int j = 0; j < board[0].length; j++){
                                       
                int r = (i/3) *3 + j/3;  
                int c = (j%3) + (i%3) *3;         
                char boxChar = board[r][c];
          
                if(boxChar != '.'){
                    int box = Character.getNumericValue(boxChar);
                    if(boxMap.containsKey(box)){
                        int frequency = boxMap.get(box);
                        boxMap.put(box,frequency+1);
                    }else{
                        boxMap.put(box,1);
                    }
                }
                
                char colChar = board[i][j];
                if(colChar != '.'){
                    int col = Character.getNumericValue(colChar);
                    if(rowMap.containsKey(col)){
                        int frequency = rowMap.get(col);
                        rowMap.put(col,frequency+1);
                    }else{
                        rowMap.put(col,1);
                    }
                 
                }

                char rowChar = board[j][i];
                if(rowChar != '.'){
                    int row = Character.getNumericValue(rowChar);
                    if(colMap.containsKey(row)){
                        int frequency = colMap.get(row);
                        colMap.put(row,frequency+1);
                    }else{
                        colMap.put(row,1);
                    }
                 
                }
                
            }

            if(boxMap.size() > 0 && Collections.max(boxMap.values()) > 1){
                return false;
            }
            if(rowMap.size() > 0 && Collections.max(rowMap.values()) > 1){
                return false;
            }
            if(colMap.size() > 0 && Collections.max(colMap.values()) > 1){
                return false;
            }
        }

        return true;
    }
}