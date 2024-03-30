#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        vector<int> cur;
        backtrack(res, nums, cur, 0);
        return res;
    }

    void backtrack(vector<vector<int>>& res, vector<int>& nums, vector<int>& cur, int idx) {
        res.push_back(cur);
        for (int i = idx; i < nums.size(); ++i) {
            if (i == idx || nums[i] != nums[i - 1]) {
                cur.push_back(nums[i]);
                backtrack(res, nums, cur, i + 1);
                cur.pop_back();
            }
        }
    }
};
