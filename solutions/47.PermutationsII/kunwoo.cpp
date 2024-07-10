class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> answer;
        int length = nums.size();
        
        if (length == 1) {
            answer.push_back(nums);
            return answer;
        }
        
        std::unordered_map<int, bool> hashmap;

        for (int i = 0; i < length; i++) {
            if (hashmap.find(nums[i]) == hashmap.end()) {
                hashmap[nums[i]] = true;
                auto backup = nums;
                nums.erase(nums.begin() + i);
                for (const auto &result : permuteUnique(nums)) {
                    vector<int> permutation({backup[i]});
                    permutation.insert(permutation.end(), result.begin(), result.end());
                    answer.push_back(permutation);
                }
                nums = backup;
            }
        }

        return answer;
    }
};
