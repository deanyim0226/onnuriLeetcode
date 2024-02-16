#include <unordered_map>
#include <unordered_set>
#include <string>

using namespace std;
class Solution {
public:
    int characterReplacement(string s, int k) {
        int max_frequency = 0;
        unordered_map<char, int> ch_freq;
        unordered_map<int, unordered_set<char>> freq_ch; //
        int lo = 0;
        int hi = 0;
        int res = 0;
        for (char elem: s) {
            if (ch_freq.find(elem) == ch_freq.end()) {
                ch_freq[elem] = 0;
            }
            ++ch_freq[elem];

            freq_ch[ch_freq[elem]].insert(elem);
            max_frequency = max(max_frequency, ch_freq[elem]);
            if (ch_freq[elem] > 1) {
                freq_ch[ch_freq[elem] - 1].erase(elem);
            }
            
            while (max_frequency + k < hi - lo + 1) {
                char popoff = s.at(lo);
                int freq_popoff = ch_freq[popoff];
                freq_ch[freq_popoff].erase(popoff);
                if (freq_ch[freq_popoff].empty() && freq_popoff == max_frequency) {
                    --max_frequency;
                }
                if (freq_popoff > 0) {
                    freq_ch[freq_popoff - 1].insert(popoff);
                }
                --ch_freq[s.at(lo)];
                ++lo;
            }
            res = max(res, hi - lo + 1);
            ++hi;
        }
        return res;
    }
};