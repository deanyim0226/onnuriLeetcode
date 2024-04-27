#include <vector>

using namespace std;

class Solution {
public:

     int helper(const vector<int>& n){ 

        int currmax = 0;
        int prevmax = 0;

        for(int i=0; i<n.size(); ++i){

            int temp = currmax;
            currmax = max(prevmax+n[i], currmax);
            prevmax = temp;
        }

        return currmax;
    }

    int rob(vector<int>& nums){

        if(nums.size()==1){

            return nums[0];
        }

        int firsthouse = helper(vector<int>(nums.begin(), nums.end()-1));
        int lasthouse = helper(vector<int>(nums.begin()+1, nums.end())); 

        return max(firsthouse, lasthouse);
    }
};