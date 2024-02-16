#include <vector>
#include <math.h>
using namespace std;

class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int lo = 1, hi = 1e9;
        while (lo <= hi) {
            long long time_needed = 0;
            int rate = lo + (hi - lo)/2;
            
            for (int elem: piles) {
                time_needed += ceil(elem/(double)rate);
            }
            if (time_needed > h) {
                lo = rate + 1;
            } else {
                hi = rate - 1;
            }
        }
        return lo;
    }
};