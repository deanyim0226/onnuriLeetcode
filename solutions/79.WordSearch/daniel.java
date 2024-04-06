class Solution {

    public boolean backtracking(char[][] board, String word, int index, int row, int col){
        
        if(index == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row > board.length-1 || col > board[0].length-1 || board[row][col] != word.charAt(index)){
            return false;
        }

        board[row][col] = '0';
   
        if( backtracking(board,word,index+1,row-1,col)){
            return true;
        }
        
        if(  backtracking(board,word,index+1,row,col-1)){
           return true;
        }
        
        if(  backtracking(board,word,index+1,row+1,col)){
            return true;
        }
        
        if( backtracking(board,word,index+1,row,col+1)){
           return true;
        }

        board[row][col] = word.charAt(index);

        return false;
    }

    public boolean exist(char[][] board, String word) {

        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){

                if(board[i][j] == word.charAt(0)){
                    if(backtracking(board,word,0,i,j)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}