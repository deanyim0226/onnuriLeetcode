#include <vector>
using namespace std;
class Solution {
public:
    int rob(vector<int>& nums) {
        vector<int> robDP(nums.size());
        vector<int> notrobDP(nums.size());
        robDP[0] = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            robDP[i] = notrobDP[i - 1] + nums[i];
            notrobDP[i] = max(robDP[i - 1], notrobDP[i - 1]);
        }

        return max(robDP[nums.size() - 1], notrobDP[nums.size() - 1]);
    }
};