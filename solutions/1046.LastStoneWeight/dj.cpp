#include <queue>
#include <vector>
using namespace std;
class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> pq;
        for (int n: stones) {
            pq.push(n);
        }
        while (pq.size() > 1) {
            int x = pq.top();
            pq.pop();
            int y = pq.top();
            pq.pop();
            if (x > y) {
                pq.push(x - y);
            }
        }
        
        if (pq.empty()) {
            return 0;
        } else {
            return pq.top();
        }
    }
};