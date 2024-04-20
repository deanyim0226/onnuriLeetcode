#include <vector>
#include <queue>

using namespace std;


class KthLargest {
public:
    KthLargest(int k, vector<int>& nums) {

      this->k = k;
      for (int i = 0; i < nums.size(); ++i) {
            pq.push(nums[i]);

            // pq = [2, 3, 4, 4, 5, 5, 8, 9, 10] 
            // k = 3

            if (pq.size() > this->k) {
                // size = 8 > k = 3

                // size = k

                pq.pop();
                //pop 

                // 3, 4, 4, 5, 5, 8, 9, 10
                // 4, 4, 5, 5, 8, 9, 10
                // 4, 5, 5, 8, 9, 10
                //5, 5, 8, 9, 10
                //5, 8, 9, 10
                //8, 9, 10
            }
        }
    }

    int add(int val) {

        pq.push(val);
        if (pq.size() > this->k) {
            
            pq.pop();
        }
        return pq.top(); 
        // 8, 9, 10 -> top -> 8
    }

private:
    priority_queue<int, vector<int>, greater<int>> pq;
    int k;
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */