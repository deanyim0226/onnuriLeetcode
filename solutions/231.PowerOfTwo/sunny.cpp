#include <iostream>

using namespace std;


class Solution {
    public:
        
    bool helper(int n){

        if(n==1){

            return true;  //base case
        }

        if(n <= 0 || n%2 != 0){

            return false;
        }

        return helper(n/2);
        
    }

        
    
    bool isPowerOfTwo(int n) {

        return helper(n);
        
    }

    
   
};
