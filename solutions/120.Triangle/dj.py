class Solution:
    def minimumTotal(self, triangle: list[list[int]]) -> int:
        sz = len(triangle)
        dp = triangle[0]
        for i in range(1, sz):
            next_dp = [float('inf')] * len(triangle[i])
            for j in range(len(triangle[i])):
                if j == 0:
                    next_dp[j] = dp[j] + triangle[i][j]
                elif j == len(triangle[i]) - 1:
                    next_dp[j] = dp[j - 1] + triangle[i][j]
                else:
                    next_dp[j] = min(dp[j], dp[j - 1]) + triangle[i][j]
            dp = next_dp

        return min(dp)