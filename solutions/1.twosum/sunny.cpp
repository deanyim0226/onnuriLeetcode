#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;



class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        unordered_map<int, int> number;

        for(int i = 0; i < nums.size(); i++){

            int n = target - nums[i];

            if(number.find(n) != number.end()){

                return {number [n], i};
            }
            
            number[nums[i]] = i;
           

        }

        return {};
    }
    
};
