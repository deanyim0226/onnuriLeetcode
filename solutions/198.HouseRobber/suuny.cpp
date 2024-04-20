#include <vector>

using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
    
      int currmax = 0;
      int prevmax = 0;

      for(int i=0; i<nums.size(); ++i){

        int temp = currmax; 
        currmax = max(prevmax+nums[i], currmax);
      

        prevmax = temp;

        

      }
        
        return currmax;
    }
};