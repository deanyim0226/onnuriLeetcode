class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        buckets = [0] * (limit + 1)
        for w in people:
            buckets[w] += 1
        
        lo, hi = 0, limit
        ans = 0
        while lo <= hi and not buckets[lo]:
            lo += 1
        while lo <= hi and not buckets[hi]:
            hi -= 1
        while lo <= hi:
            buckets[hi] -= 1
            ans += 1
            if lo + hi <= limit and buckets[lo]:
                buckets[lo] -= 1

            while lo <= hi and not buckets[lo]:
                lo += 1
            while lo <= hi and not buckets[hi]:
                hi -= 1
        
        return ans