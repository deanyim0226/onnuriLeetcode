#include <stack>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> st;
        for (string elem: tokens) {
            if (elem == "+" || elem == "-" || elem == "*" || elem == "/") {
                int snd = st.top();
                st.pop();
                int fst = st.top();
                st.pop();
                if (elem == "+") st.push(fst+snd);
                else if (elem == "-") st.push(fst-snd);
                else if (elem == "*") st.push(fst*snd);
                else st.push(fst/snd);
            } else {
                st.push(stoi(elem));
            }
        }
        return st.top();
    }
};