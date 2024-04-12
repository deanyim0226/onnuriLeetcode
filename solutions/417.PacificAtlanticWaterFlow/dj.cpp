#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int rows = heights.size();
        int cols = heights[0].size();
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        vector<vector<int>> reachable(rows, vector<int>(cols, 0));
        //1 means from Pacific and 2 means from Atlantic
        for (int i = 0; i < rows; ++i) {
            dfs(heights, reachable, dirs, i, 0, 1);
            dfs(heights, reachable, dirs, i, cols - 1, 2);
        }
        for (int i = 0; i < cols; ++i) {
            dfs(heights, reachable, dirs, 0, i, 1);
            dfs(heights, reachable, dirs, rows - 1, i, 2);
        }

        vector<vector<int>> res;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (reachable[i][j] == 3) res.push_back({i, j});
            }
        }
        return res;
    }

    void dfs(vector<vector<int>>& board, vector<vector<int>>& reachable, vector<vector<int>>& dirs, int r, int c, int factor) {
        if (reachable[r][c] & factor) return;

        reachable[r][c] += factor;
        
        for (int i = 0; i < 4; ++i) {
            int nxtr = r + dirs[i][0];
            int nxtc = c + dirs[i][1];
            if (0 <= nxtr && nxtr < board.size() && 0 <= nxtc && nxtc < board[0].size() && board[nxtr][nxtc] >= board[r][c]) {
                dfs(board, reachable, dirs, nxtr, nxtc, factor);
            }
        }
    }
};