#include <unordered_set>
using namespace std;

class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> mk;
        while (n != 1) {
            if (mk.count(n) > 0) return false;
            mk.insert(n);
            int nxt = 0;
            while (n > 0) {
                nxt += (n % 10) * (n % 10);
                n /= 10;
            }
            n = nxt;
        }
        return true;
    }
};