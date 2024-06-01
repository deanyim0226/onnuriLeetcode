import heapq
class Solution:
    def leastInterval(self, tasks: list[str], n: int) -> int:
        cur = 0
        pq = []

        track = {}

        for A in tasks:
            if A in track:
                heapq.heappush(pq, (track[A] + n + 1, A))
                track[A] += n + 1
            else:
                heapq.heappush(pq, (0, A))
                track[A] = 0
        
        while pq:
            time = heapq.heappop(pq)[0]
            if time <= cur:
                cur += 1
            else:
                cur = time + 1
        
        return cur