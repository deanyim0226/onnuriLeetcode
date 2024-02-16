#include <vector>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int lo = 0;
        int hi = nums.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
};