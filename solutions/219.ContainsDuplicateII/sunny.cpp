#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        
        unordered_map<int, int> index; 

        
       for(int i =0; i<nums.size(); ++i){

           if(index.find(nums[i]) != index.end() && i - index[nums[i]] <= k){

               return true;
           }


            index[nums[i]] = i;
       }



       return false;
    }
};