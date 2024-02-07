#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    bool isValid(string s) {
        vector<char> st;
        for (char elem: s) {
            if (elem == '(' || elem == '[' || elem == '{') {
                st.push_back(elem);
            } else {
                if (st.empty()) return false;
                char last = st.back();
                st.pop_back();
                if ((elem == ')' && last != '(') ||
                    (elem == ']' && last != '[') ||
                    (elem == '}' && last != '{')) return false;
            }
        }
        // Check if every bracket closed
        return st.empty();
    }
};