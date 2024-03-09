#include <vector>

using namespace std;

class Solution {
public:
    bool predictTheWinner(vector<int>& nums) {
        vector<vector<int>> dp(nums.size() + 1, vector<int>(nums.size(), -1));
        return getDP(0, nums.size() - 1, dp, nums) >= 0;
    }
    int getDP(int lo, int hi, vector<vector<int>>& dp, vector<int>& nums) {
        if (dp[lo][hi] == -1) {
            if (lo == hi) {
                dp[lo][hi] = nums[lo];
            } else {
                dp[lo][hi] = max(-getDP(lo + 1, hi, dp, nums) + nums[lo], -getDP(lo, hi - 1, dp, nums) + nums[hi]);
            }
        }
        return dp[lo][hi];
    }
};