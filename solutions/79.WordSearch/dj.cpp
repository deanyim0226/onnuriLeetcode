#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int sizerow = board.size();
        int sizecol = board[0].size();
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        vector<vector<bool>> visited(sizerow, vector<bool>(sizecol, false));
        for (int i = 0; i < sizerow; ++i) {
            for (int j = 0; j < sizecol; ++j) {
                if (board[i][j] == word[0]) {
                    vector<char> cur = {word[0]};
                    visited[i][j] = true;
                    if (backtrack(board, cur, visited, word, dirs, i, j)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    bool backtrack(vector<vector<char>>& board, vector<char>& cur, vector<vector<bool>>& visited, string& word, vector<vector<int>>& dirs, int r, int c) {
        if (cur.size() == word.size()) return true;
        bool ans = false;
        for (int i = 0; i < 4; ++i) {
            int nxtr = r + dirs[i][0];
            int nxtc = c + dirs[i][1];
            if (nxtr >= 0 && nxtr < board.size() && nxtc >= 0 && nxtc < board[0].size() && !visited[nxtr][nxtc] && board[nxtr][nxtc] == word[cur.size()]) {
                cur.push_back(board[nxtr][nxtc]);
                visited[nxtr][nxtc] = true;
                ans = ans || backtrack(board, cur, visited, word, dirs, nxtr, nxtc);
                cur.pop_back();
                visited[nxtr][nxtc] = false;
            }
        }
        return ans;
    }
};