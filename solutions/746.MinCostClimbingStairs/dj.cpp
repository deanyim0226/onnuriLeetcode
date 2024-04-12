#include <vector>
using namespace std;

class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        vector<int> dp(cost.size() + 1, -1);
        dp[0] = 0;
        dp[1] = 0;
        return getDP(dp, cost, cost.size());
    }
    int getDP(vector<int>& dp, vector<int>& cost, int idx) {
        if (dp[idx] == -1) {
            dp[idx] = min(getDP(dp, cost, idx - 1) + cost[idx-1], getDP(dp, cost, idx - 2) +cost[idx-2]);
        }
        return dp[idx];
    }
};