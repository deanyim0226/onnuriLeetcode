#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> result;
        int left = 0;
        int right = numbers.size()-1;

        while(left < right){


            int sum = numbers[left]+numbers[right];

            if(target == sum){

                result = {left+1, right+1};

                return result;
            }

            if(target < sum){

                right --;
            }


            else{

                left++;
            }


        }

        return {};
    }
}; 