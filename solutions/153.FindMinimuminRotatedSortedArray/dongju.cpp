#include <vector>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int lo = 0;
        int hi = nums.size() - 1;
        int minval = nums[0];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //Left subarray is increasing
            if (nums[lo] <= nums[mid]) {
                //We know nums[lo] is the smallest in this subarray
                minval = min(minval, nums[lo]);
                lo = mid + 1;
            } else {
                minval = min(minval, nums[mid]);
                hi = mid - 1;
            }
        }
        return minval;
    }
};