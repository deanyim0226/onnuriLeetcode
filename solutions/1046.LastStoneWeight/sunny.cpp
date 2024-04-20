#include <vector>
#include <queue>

using namespace std;


class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {


        priority_queue<int> pq; // max heap 
        for (int i = 0; i < stones.size(); ++i) {
            pq.push(stones[i]);

            // pq = [8, 7, 4, 2, 1, 1]
        }

        while (pq.size() > 1) {
            // top -> 8
            int large = pq.top();
            pq.pop();

            // pq = [7, 4, 2, 1, 1] top->7
            int secondl = pq.top();
            pq.pop();
            // [4, 2, 1, 1]

            int result = large - secondl;
            // 8-7 = result

            if (result != 0) {
                pq.push(result); // Add result back to the queue
            }
        }


        return pq.size()?pq.top():0;
//either the top element of the priority queue if it's not empty, or 0 if it is empty. 

    }

};