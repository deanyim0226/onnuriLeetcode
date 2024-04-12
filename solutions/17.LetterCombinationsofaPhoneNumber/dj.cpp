#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) return {};
        vector<string> res = {""};
        vector<string> representation = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.size(); ++i) {
            vector<string> next;
            for (char cur: representation[digits[i] - '0']) {
                for (string prev: res) {
                    next.push_back(prev + cur);
                }
            }
            res = next;
        }
        return res;
    }
};