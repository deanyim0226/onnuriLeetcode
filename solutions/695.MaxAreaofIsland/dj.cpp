#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int rsize = grid.size();
        int csize = grid[0].size();
        vector<vector<int>> visited(rsize, vector<int>(csize, 0));
        int res = 0;
        for (int i = 0; i < rsize; ++i) {
            for (int j = 0; j < csize; ++j) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {

                    res = max(res, dfs(grid, visited, i, j));
                }
            }
        }
        return res;
    }
    int dfs(vector<vector<int>>& grid, vector<vector<int>>& visited, int r, int c) {
        visited[r][c] = 1;
        int area = 1;
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; ++i) {
            int nxtr = r + dirs[i][0];
            int nxtc = c + dirs[i][1];
            if (nxtr >= 0 && nxtr < grid.size() && nxtc >= 0 && nxtc < grid[0].size() && grid[nxtr][nxtc] == 1 && visited[nxtr][nxtc] == 0) {
                area += dfs(grid, visited, nxtr, nxtc);
            }
        }
        return area;
    }
};