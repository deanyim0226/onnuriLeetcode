#include <iostream>
#include <vector>
#include <unordered_map>

class Solution {
public:
    bool containsDuplicate(std::vector<int>& nums) {
      /* 
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
    */ 

        
        
       std::unordered_map<int, int> elementcount; //declare hashmap for elemencount

       //i want to get elements in the list as the key value and if there are duplicate elements then will count 1++ as the value
        
       for(int element : nums){

           elementcount[element]++;
       }


    // return ture if there are duplicate elements 
       for(auto pair : elementcount){
           if(pair.second > 1){

               return true;
           }
       }

         return false;
     
 };
 



  

};


    
    


