class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int start = 0;
        int end = nums.size() - 1;
        while (true) {
            int total_size = end - start + 1;
            int target_idx = start + total_size / 2;

            if (total_size == 1) {
                return nums[target_idx];
            }

            if (total_size / 2 % 2 == 1) {
                if (nums[target_idx] == nums[target_idx+1]) {
                    end = target_idx - 1;
                    continue;
                } else {
                    start = target_idx + 1;
                    continue;
                }
            } else {
                if (nums[target_idx] == nums[target_idx+1]) {
                    start = target_idx + 2;
                    continue;
                } else {
                    end = target_idx;
                    continue;
                }
            }
        }
    }
};
