import heapq
class Solution:
    def networkDelayTime(self, times: list[list[int]], n: int, k: int) -> int:
        graph = [[] for _ in range(n + 1)]
        for u, v, w in times:
            graph[u].append([v, w])
  
        pq = [[0, k]]
        costs = [float('inf')] * (n + 1)
        costs[k] = 0

        while pq:
            cur_cost, v = heapq.heappop(pq)
            if cur_cost == costs[v]:
                for nxt, w in graph[v]:
                    if cur_cost + w < costs[nxt]:
                        costs[nxt] = cur_cost + w
                        heapq.heappush(pq, [costs[nxt], nxt])

        ans = 0
        for i in range(1, n + 1):
            cost = costs[i]
            if cost == float('inf'):
                return -1
            ans = max(ans, cost)
        
        return ans