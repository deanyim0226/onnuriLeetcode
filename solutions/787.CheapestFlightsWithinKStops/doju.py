class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = [[] for _ in range(n)]
        for u, v, c in flights:
            graph[u].append((v, c))
        

        # dp[i][dest] represents min cost connect src-dest at most i stops
        dp = [[float('inf')] * n for row in range(k + 1)]
        for v, c in graph[src]:
            dp[0][v] = c
        
        for stops in range(k):
            for u in range(n):
                if dp[stops][u] < float('inf'):
                    dp[stops + 1][u] = min(dp[stops + 1][u], dp[stops][u])
                    for v, c in graph[u]:
                        dp[stops + 1][v] = min(dp[stops + 1][v], dp[stops][u] + c)

        return dp[-1][dst] if dp[-1][dst] < float('inf') else -1