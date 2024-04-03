#include <vector>
using namespace std;

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        vector<vector<int>> dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        int res = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == '1') {
                    dfsVisit(grid, dirs, i, j);
                    ++res;
                }
            }
        }
        return res;
    }
    void dfsVisit(vector<vector<char>>& grid, vector<vector<int>>& dirs, int r, int c) {
        grid[r][c] = '0';
        for (int i = 0; i < 4; ++i) {
            int nxtR = r + dirs[i][0];
            int nxtC = c + dirs[i][1];
            if (nxtR >= 0 && nxtR < grid.size() && nxtC >= 0 && nxtC < grid[0].size() && grid[nxtR][nxtC] == '1')
            dfsVisit(grid, dirs, nxtR, nxtC);
        }
    }
};