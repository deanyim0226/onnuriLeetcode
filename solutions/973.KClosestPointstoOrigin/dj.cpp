#include <vector>
#include <queue>

using namespace std;

class Solution {
    struct Compare {
        bool operator()(pair<int, int> a, pair<int, int> b) {
            return a.first * a.first + a.second * a.second > b.first * b.first + b.second * b.second;
        }
    };

public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        vector<vector<int>> ans;
        priority_queue<pair<int, int>, vector<pair<int, int>>, Compare> pq; 
        for (auto elem: points) {
            pq.push({elem[0], elem[1]});
        }
        while (k > 0) {
            auto cur = pq.top();
            vector<int> tmp = {cur.first, cur.second};
            ans.push_back(tmp);
            pq.pop();
            --k;
        }
        return ans;
    }
};