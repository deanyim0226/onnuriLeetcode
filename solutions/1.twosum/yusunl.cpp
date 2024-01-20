#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map <int, int> hash;
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++) {
            if (hash.find(target - nums[i]) == hash.end()) hash[nums[i]] = i;
            else {
                ans.push_back(i);
                ans.push_back(hash[target - nums[i]]);
                break;
            }
        }
        return ans;
    }
};