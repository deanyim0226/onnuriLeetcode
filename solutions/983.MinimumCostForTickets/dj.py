class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0] *  366
        p_days = 0

        for i in range(1, 366):
            if p_days < len(days) and days[p_days] == i:
                dp[i] = dp[i - 1] + costs[0]
                dp[i] = min(dp[i], dp[i - 7] + costs[1] if i >= 7 else costs[1])
                dp[i] = min(dp[i], dp[i - 30] + costs[2] if i >= 30 else costs[2])

                p_days += 1
            else:
                dp[i] = dp[i - 1]
        
        return dp[-1]