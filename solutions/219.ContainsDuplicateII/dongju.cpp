#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        int lo = 0;
        unordered_set<int> elems;
        size_t sk = k;
        for (int i = 0; i < min(sk + 1, nums.size()); ++i) {
            int cur = nums[i];
            if (elems.find(cur) != elems.end()) return true;
            elems.insert(cur);
        }
        for (int i = k + 1; i < nums.size(); ++i) {
            int cur = nums[i];
            elems.erase(nums[lo++]);
            if (elems.find(cur) != elems.end()) return true;
            elems.insert(cur);
        }
        return false;
    }
};