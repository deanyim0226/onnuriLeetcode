#include <iostream>
#include <vector>

class Solution {
public:
    bool containsDuplicate(std::vector<int>& nums) {
        
       int size = nums.size();

       for(int i=0; i < size; i++){

          for(int j=i+1; j < size; j++){

              if(nums[i] == nums[j]){

                  return true;
              }
            
          }

    
       }

       return false;
     
    }

};

