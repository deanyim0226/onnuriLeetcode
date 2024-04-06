class Solution {

    // visited grid to save time from rechecking the same visited word
    boolean visited[][];

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols]; 
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++){
                // find the first letter of the target word
                if(board[i][j] == word.charAt(0) && searchWord(i, j, 0, board, word))
                    return true;
            }
        }

        return false;
    }

    // helper function to search around a specified character
    public boolean searchWord(int row, int col, int index, char[][] board, String word)
    {
        // if index count has reached the end of the word, that means we found the word
        if(index == word.length())
            return true;
        
        // boundary checks
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length || word.charAt(index) != board[row][col] || visited[row][col])
            return false;

        visited[row][col] = true;

        // search up, down, right and left
        if(searchWord(row+1, col, index+1, board, word) ||
        searchWord(row-1, col, index+1, board, word) ||
        searchWord(row, col+1, index+1, board, word) ||
        searchWord(row, col-1, index+1, board, word))
            return true; 

        // reset it to false so it can be potentially used for another combination
        visited[row][col] = false;
        return false;
    }
}