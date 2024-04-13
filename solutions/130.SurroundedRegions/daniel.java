class Solution {

    public void dfs(char[][] board, int row, int col){
        
        if(row < 0 || col < 0 || row > board.length-1 || col > board[0].length-1 || board[row][col] != 'O'){
            return;
        }

        board[row][col] = 'C';

        dfs(board,row+1,col);
        dfs(board,row-1,col);
        dfs(board,row,col+1);
        dfs(board,row,col-1);
        
    }
    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;
        
        for(int i=0; i < col; i++){
            if(board[0][i] == 'O'){
                dfs(board,0,i);
            }

            if(board[row-1][i] == 'O'){
                dfs(board,row-1,i);
            }
        }

        for(int i= 0; i < row; i++){
            if(board[i][0] == 'O'){
                dfs(board,i,0);
            }
            if(board[i][col-1] == 'O'){
                dfs(board,i,col-1);
            }
        }

        for(int i =0; i < board.length; i++){
            for(int j =0; j<board[0].length; j++){

                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        for(int i =0; i < board.length; i++){
            for(int j =0; j<board[0].length; j++){

                if(board[i][j] == 'C'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}