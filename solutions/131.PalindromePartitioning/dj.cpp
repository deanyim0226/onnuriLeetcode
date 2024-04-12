#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> res;
        vector<string> cur;
        backtrack(res, cur, s, 0);
        return res;
    }

    void backtrack(vector<vector<string>>& res, vector<string>& cur, string& s, int idx) {
        if (idx == s.size()) {
            res.push_back(vector<string>(cur));
            return;
        }
        for (int i = idx; i < s.size(); ++i) {
            if (isPalindrome(s, idx, i)) {
                cur.push_back(s.substr(idx, i - idx + 1));
                backtrack(res, cur, s, i + 1);
                cur.pop_back();
            }
        }
    }

    bool isPalindrome(string& s, int lo, int hi) {
        while (lo < hi) {
            if (s[lo] != s[hi]) return false;
            ++lo;
            --hi;
        }
        return true;
    }
};