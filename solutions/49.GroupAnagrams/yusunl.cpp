#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution{
public:
    vector<vector<string>> groupAnagrams(vector<string>&strs) {
        vector<vector<string>> ans;
        unordered_map<string, int> hash;
        for (int i = 0; i < strs.size(); i++) {
            string tmp = strs[i];
            sort(tmp.begin(), tmp.end());
            if (hash.find(tmp) != hash.end()) {
                ans[hash[tmp]].push_back(strs[i]);
            }
            else {
                vector<string> str = { strs[i],};
                hash[tmp] = ans.size();
                ans.push_back(str);
            }
        }
        return ans;
    }
};