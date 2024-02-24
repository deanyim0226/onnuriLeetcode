#include <vector>
#include <string>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> q;
        q.push_back("(");
        for (int i = 1; i < n*2; ++i) {
            vector<string> nxt;
            for (string elem: q) {
                int cnt_open = 0;
                for (char ch: elem) {
                    if (ch == '(') ++cnt_open;
                }
                if (cnt_open < n) {
                    string newstring = elem;
                    newstring.append("(");
                    nxt.push_back(newstring);
                }
                if (i - cnt_open < cnt_open) {
                    string newstring = elem;
                    newstring.append(")");
                    nxt.push_back(newstring);
                }
            }
            q=nxt;
        }
        cout << q.size();
        return q;
    }
};

int main() {
    Solution solution;
    int n = 10;  // Change this value to generate parentheses for a different number
    vector<string> result = solution.generateParenthesis(n);
    cout << "Generated Parentheses for n = " << n << ":" << result.size();

    return 0;
}