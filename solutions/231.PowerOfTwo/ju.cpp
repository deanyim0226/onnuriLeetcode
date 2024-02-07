class Solution {
public:
    bool isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int base = 1;
        for (int i = 0; i < 30; i++) {
            
            if (n == base) {
                return true;
            }
            base *= 2;
        }
        return base == n;
    }
};