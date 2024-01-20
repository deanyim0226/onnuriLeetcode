#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<int, bool> checkDup;
        bool ans = false;
        for (int i = 0; i < nums.size(); i++) {
            if (checkDup.find(nums[i]) == checkDup.end()) {
                checkDup[nums[i]] = true;
            }
            else {
                ans = true;
                break;
            }

        }
        return ans;
    }
};

