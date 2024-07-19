class Solution {
private:
    int dp[59] = {0};

public:
    int integerBreak(int n) {
        int maxProduct = 0;        
        for (int i = 1; i < n; i++) {
            maxProduct = max(maxProduct, i * integerBreakInternal(n-i));
        }
        return maxProduct;
    }

    int integerBreakInternal(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }

        int maxProduct = n;
        for (int i = 1; i < n; i++) {
            maxProduct = max(maxProduct, i * integerBreakInternal(n-i));
        }
        dp[n] = maxProduct;
        return dp[n];
    }
};
