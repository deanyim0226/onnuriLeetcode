#include <iostream>
#include <stack>

using namespace std;


class Solution {
public:
    bool isValid(string s) {

        stack<char> bracket;
        int n = s.size();

        if (n <= 1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
                bracket.push(s[i]);
            } else {
                if (bracket.empty()) {
                    return false;
                }

                char top = bracket.top(); // (, [, { check with ), ], }
                bracket.pop(); // remove open bracket

                if (s[i] == ')' && top != '(' || s[i] == ']' && top != '[' || s[i] == '}' && top != '{') {
                    return false;
                }
            }
        }

        return bracket.empty(); 
        
    }
};