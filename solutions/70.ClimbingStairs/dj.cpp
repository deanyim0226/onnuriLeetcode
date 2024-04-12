#include <vector>
using namespace std;

class Solution {
public:
    int solve(vector<int> & vt, int i) {
        if (vt[i] == 0) {
            vt[i] = solve(vt, i-1) + solve(vt, i-2);
        }
        return vt[i];
    }
    int climbStairs(int n) {
        vector<int> dp(n+1);
        dp[0] = 1;
        dp[1] = 1;
        return solve(dp, n);
    }
};