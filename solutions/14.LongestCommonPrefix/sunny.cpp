#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {

       string result = "";

       for(int i=0; i<strs[0].size(); i++){

           char c = strs[0][i];
       

       for(int j=1; j <strs.size(); j++){

           if(i >= strs[j].size() || strs[j][i] != c){

               return result;
           }
       }


       result += c;

        }

     
        return result;
             
    }
};