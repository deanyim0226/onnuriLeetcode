class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        profit = 0
        # " 7 , 1, 5 , 4, 6 , 4"

        #.      l       r
        min_seen_so_far = float("inf")

        r = 0
        while r <= len(prices) -1 :

            if prices[r] < min_seen_so_far:
                min_seen_so_far = prices[r]

            if min_seen_so_far < prices[r]:

                profit = max(profit , prices[r] - min_seen_so_far )

            r +=1

        return profit