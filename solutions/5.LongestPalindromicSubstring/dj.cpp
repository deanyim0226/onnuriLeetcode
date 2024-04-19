#include <vector>
#include <string>
using namespace std;


class Solution {
public:
    string longestPalindrome(string s) {
        string res = "";
        int sz = s.size();
        vector<vector<int>> mp(sz, vector<int>(sz, -1));
        for (int i = 0; i < sz; ++i) {
            for (int j = i; j < sz; ++j) {
                if (getPalindrome(s, mp, i, j) == 1 && j - i + 1> res.size()) {
                    res = s.substr(i, j - i + 1);
                }
            }
        }
        return res;
    }

    bool getPalindrome(string&s, vector<vector<int>>& mp, int lo, int hi) {
        if (lo == hi) return 1;
        if (lo == hi + 1) return 1;
        if (mp[lo][hi] == -1) {
            mp[lo][hi] = 0;
            int mid = getPalindrome(s, mp, lo + 1, hi - 1);
            if (mid == 1 && s[lo] == s[hi]) {
                mp[lo][hi] = 1;
            }
        }

        return mp[lo][hi];
    }
};