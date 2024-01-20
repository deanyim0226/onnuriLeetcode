#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<int> ans;
        unordered_map <int, int> hash;
        priority_queue<pair<int, int>> pq;

        for (int i = 0; i < nums.size(); i++) {
            if (hash.find(nums[i]) == hash.end())hash[nums[i]] = 1;
            else hash[nums[i]]++;
        }
        for (const auto& entry : hash) {
            pq.push(make_pair(entry.second, entry.first));//frequency:elements
        }

        while (k--) {
            ans.push_back(pq.top().second); //elements
            pq.pop();
        }

        return ans;
    }
};
