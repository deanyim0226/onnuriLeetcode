#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> init;
        backtrackingHelper(candidates, 0, res, init, target);
        return res;
    }

    void backtrackingHelper(vector<int>& candidates, int idx, vector<vector<int>>& res, vector<int>& cur, int target) {
        if (target == 0) {
            res.push_back(cur);
            return;
        }
        for (int i = idx; i < candidates.size(); ++i) {
            if (target - candidates[i] >= 0) {
                vector<int> nxt(cur);
                nxt.push_back(candidates[i]);
                backtrackingHelper(candidates, i, res, nxt, target - candidates[i]);
            }
        }
    }
};