class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        n = len(coins)
        dp = [float('inf')] * (amount + 1)

        dp[0] = 0
        
        for i in range(1, amount + 1):
            for j in range(n):
                val = coins[j]
                if i - val >= 0:
                    dp[i] = min(dp[i], dp[i - val] + 1)
        
        return -1 if dp[-1] == float('inf') else dp[-1]
