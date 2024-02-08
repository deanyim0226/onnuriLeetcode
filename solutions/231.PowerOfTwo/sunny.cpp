#include <iostream>

using namespace std;


class Solution {
public:
    bool isPowerOfTwo(int n) {

         if(n==1){

            return true;  //base case
        }

        if(n <= 0 || n%2 != 0){

            return false;
        }

        return isPowerOfTwo(n/2);
        
    }
        
};
