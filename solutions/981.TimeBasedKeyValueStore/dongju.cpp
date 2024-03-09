#include <unordered_map>
#include <vector>
#include <string>

using namespace std;


class TimeMap {
    unordered_map<string, vector<pair<int, string>>> mp;

public:
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        if (mp.find(key) == mp.end()) {
            mp[key] = vector<pair<int, string>>();
        }
        mp[key].push_back({timestamp, value});
    }
    
    string get(string key, int timestamp) {
        if (mp.find(key) == mp.end()) return "";
        vector<pair<int,string>>& target = mp[key];
        int lo = 0;
        int hi = target.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (timestamp < target[mid].first) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (lo == 0) return "";
        return target[lo-1].second;
    }
};