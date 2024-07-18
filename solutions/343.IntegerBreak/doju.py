class Solution:
    def integerBreak(self, n: int) -> int:
        dp = [-1] * (n + 1)
        dp[1] = 1
        def getDP(val):
            if dp[val] == -1:
                dp[val] = (val // 2) * (val // 2)
                for i in range(1, val // 2 + 1):
                    dp[val] = max(dp[val], i * max(getDP(val - i), val - i))
            return dp[val]
        
        return getDP(n)