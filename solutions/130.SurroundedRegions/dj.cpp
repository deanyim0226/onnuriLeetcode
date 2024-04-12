#include <vector>
using namespace std;

class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int size_r = board.size();
        int size_c = board[0].size();
        for (int i = 0; i < size_r; ++i) {
            dfs(board, i, 0);
            dfs(board, i, size_c - 1);
        }
        for (int i = 0; i < size_c; ++i) {
            dfs(board, 0, i);
            dfs(board, size_r - 1, i);
        }

        for (int i = 0; i < size_r; ++i) {
            for (int j = 0; j < size_c; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(vector<vector<char>>& board, int r, int c) {
        if (r < 0 || r >= board.size() || c < 0 || c >= board[0].size()) return;
        if (board[r][c] == 'X' || board[r][c] == 'A') return;
        //'A' means alive 'O' after game
        board[r][c] = 'A';
        
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
};