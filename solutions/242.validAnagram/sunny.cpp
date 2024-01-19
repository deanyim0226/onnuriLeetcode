#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>

using namespace std;


class Solution {
public:
    bool isAnagram(string s, string t) {

        /*

        string s and t size are must be equal if it's not then return false 

        if the letters in the string 's' and letters in the string 't' are 100% same then it's anagram - > return true 


        */

       if (s.size() != t.size()) {
            return false;
        }

   
        unordered_map<char, int> charCheck;

        for(char c : s){

            charCheck[c]++;
        }

       
       
        for (char c : t) {
            
            if (charCheck.find(c) == charCheck.end() || charCheck[c] == 0){

                    return false;
                }

                charCheck[c]--;

            
        }

    

        
        return true;
           

   
    }
};