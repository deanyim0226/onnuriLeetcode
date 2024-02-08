class Solution {
public:
    bool isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n/2);
        // if (n <= 0) {
        //     return false;
        // }
        // int base = 1;
        // for (int i = 0; i < 30; i++) {
            
        //     if (n == base) {
        //         return true;
        //     }
        //     base *= 2;
        // }
        // return base == n;
    }
};