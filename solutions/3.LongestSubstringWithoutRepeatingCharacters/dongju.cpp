#include <unordered_set>
#include <string>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int res = 0;
        unordered_set<char> unique;
        int start = 0;
        int end = 0;
        for (char elem: s) {
            while (unique.find(elem)!= unique.end()) {
                unique.erase(s.at(start));
                ++start;
            }
            unique.insert(elem);
            res = max(res, end-start+1);
            ++end;
        }
        return res;
    }
};
