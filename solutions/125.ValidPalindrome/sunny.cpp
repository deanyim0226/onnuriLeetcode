#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {


        string str;


        if(s.empty()){

            return false;
        }

        for(char c : s){

            if(isalnum(c)){

                str += tolower(c);
            }
        }

        int ptr1 = 0;
        int ptr2 = str.length() - 1;

        while(ptr1<ptr2){

            if(str[ptr1] != str[ptr2]){

                return false;
            }

            ptr1++;
            ptr2--;
        }


        return true;
        
    }
};