#include <vector>
#include <queue>

using namespace std;
class KthLargest {
    priority_queue<int> pq;
    int sz;
public:
    KthLargest(int k, vector<int>& nums) {
        for (int num: nums) {
            pq.push(-num);
        }
        while (pq.size() > k) pq.pop();
        sz = k;
    }
    
    int add(int val) {
        if (pq.size() < sz) pq.push(-val);
        else if (-val < pq.top()) {
            pq.push(-val);
            pq.pop();
        }
        return -pq.top();
    }
};
