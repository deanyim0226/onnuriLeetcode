#include <vector>
using namespace std;

class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; ++k) {
                        int nextRow = i + dirs[k][0];
                        int nextCol = j + dirs[k][1];
                        if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) ++res;
                        else if (grid[nextRow][nextCol] == 0) ++res;
                    }
                }
            }
        }
        return res;
    }
};