#include <iostream>
#include <vector>
#include <unordered_map>


using namespace std;

class Solution {
public:
    int majorityElement(vector<int>& nums) {

        int n = nums.size();
        unordered_map<int, int> Majority;

        for(auto& element : nums){

            Majority[element]++;
        }

        for(auto& times : Majority){
            if(times.second > n/2){

                return times.first;
            }
        }
        return -1;
    }

  
};
