#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> cur;
        backtrack(res, nums, cur);
        return res;
    }

    void backtrack(vector<vector<int>>& res, vector<int>& nums, vector<int>& cur) {
        if (cur.size() == nums.size()) {
            res.push_back(cur);
            return;
        }

        for (int i = 0; i < nums.size(); ++i) {
            if (find(cur.begin(), cur.end(), nums[i]) == cur.end()) {
                cur.push_back(nums[i]);
                backtrack(res, nums, cur);
                cur.pop_back();
            }
        }
    }
};