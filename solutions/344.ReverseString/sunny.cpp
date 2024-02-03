#include <iostream>
#include <vector>

using namespace std;



class Solution {
public:
    void reverseString(vector<char>& s) {
        
        /*
        int ptr1 = 0;
        int ptr2 = s.size() - 1;

        while (ptr1 < ptr2) {
            swap(s[ptr1], s[ptr2]);
            ptr1++;
            ptr2--;
        }

    */  
        helper(s, 0, s.size()-1);
   
    }

    //recusrion 
    // i = ptr1 = 0, j = ptr2 = s.size()-1

    void helper(vector<char>&s, int i, int j){

        while(i<j){

            swap(s[i], s[j]);
            i++;
            j--;
        }
        

    }
};