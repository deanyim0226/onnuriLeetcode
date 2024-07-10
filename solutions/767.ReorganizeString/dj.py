class Solution:
    def reorganizeString(self, s: str) -> str:
        cnt = Counter(s)
        pq = [(-freq, ch) for ch, freq in cnt.items()]
        heapq.heapify(pq)

        ans = ""
        while pq:
            tmpPair = None
            freq, ch = heapq.heappop(pq)
            if ans and ans[-1] == ch:
                tmpPair = (freq, ch)
                if pq:
                    freq, ch = heapq.heappop(pq)
                else:
                    return "" 
            ans += ch
            if freq < -1:
                heapq.heappush(pq, (freq + 1, ch))
            if tmpPair:
                heapq.heappush(pq, tmpPair)

        return ans