#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> res;
        vector<int> cur;
        backtrack(res, candidates, cur, target, 0);
        return res;
    }
    void backtrack(vector<vector<int>>& res, vector<int>& candidates, vector<int>& cur, int target, int idx) {
        if (target == 0) {
            vector<int> ans(cur);
            res.push_back(ans);
            return;
        }
        if (target < 0) return;
        for (int i = idx; i < candidates.size(); ++i) {
            if (i == idx || candidates[i] != candidates[i - 1]) {
                cur.push_back(candidates[i]);
                backtrack(res, candidates, cur, target - candidates[i], i + 1);
                cur.pop_back();
            }
        }
    }
};