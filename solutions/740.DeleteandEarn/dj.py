class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        cnt = collections.Counter(nums)
        arr = [0] * (10**4 + 1)
        for k in cnt:
            arr[k] = cnt[k] * k
        
        dp = [0] * (10**4 + 1)
        dp[0] = arr[0]
        dp[1] = max(arr[0], arr[1])
        for i in range(10**4 + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + arr[i])
        
        return dp[-1]