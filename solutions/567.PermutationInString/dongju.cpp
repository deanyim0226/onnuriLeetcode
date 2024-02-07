#include <string>
#include <unordered_map>

using namespace std;
class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        unordered_map<char, int> ch_cnt; //number of characters to match
        for (char elem: s1) {
            ++ch_cnt[elem];
        }
        int offset = ch_cnt.size();
        size_t lo = 0;
        size_t hi = s1.size();
        for (int i = 0; i < min(s2.size(), hi); i++) {
            char cur = s2[i];
            --ch_cnt[cur];
            if (ch_cnt[cur] == 0) --offset;
            else if (ch_cnt[cur] == -1) ++offset;
            if (offset == 0) return true;
        }
        while (hi < s2.size()) {
            char pushed = s2[hi];
            char popped = s2[lo];
            if (pushed != popped) {
                --ch_cnt[pushed];
                ++ch_cnt[popped];
                if (ch_cnt[pushed] == 0) --offset;
                else if (ch_cnt[pushed] == -1) ++offset;

                if (ch_cnt[popped] == 0) --offset;
                else if (ch_cnt[popped] == 1) ++offset;
                if (offset == 0) return true;
            }
            
            ++lo;
            ++hi;
        }
        return false;
    }
};