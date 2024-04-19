#include <vector>

using namespace std;
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int row_sz = grid.size();
        int col_sz = grid[0].size();
        int fresh_cnt = 0;
        int time = 0;
        vector<pair<int, int>> q;
        for (int i = 0; i < row_sz; ++i) {
            for (int j = 0; j < col_sz; ++j) {
                if (grid[i][j] == 1) ++fresh_cnt;
                else if (grid[i][j] == 2) q.push_back({i, j});
            }
        }

        while (!q.empty()) {
            if (fresh_cnt == 0) return time;
            vector<pair<int, int>> nq;
            for (auto elem: q) {
                int cur_r = elem.first;
                int cur_c = elem.second;
                for (int i = 0; i < 4; ++i) {
                    int nxt_r = cur_r + dirs[i][0];
                    int nxt_c = cur_c + dirs[i][1];
                    if (0 <= nxt_r && nxt_r < row_sz && 0 <= nxt_c && nxt_c < col_sz) {
                        if (grid[nxt_r][nxt_c] == 1) {
                            grid[nxt_r][nxt_c] = 2;
                            nq.push_back({nxt_r, nxt_c});
                            --fresh_cnt;
                        }
                    }
                }
            }
            ++time;
            q = nq;
        }

        return fresh_cnt == 0 ? 0: -1;
    }
};