class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        q = [(0, 0)]
        ln = len(points)
        dist = [float('inf')] * len(points)
        dist[0] = 0
        v = [False] * len(points)
        costs = 0
        
        while q:
            w, cur = heapq.heappop(q)

            if v[cur]: continue
            v[cur] = True
            costs += w
            for i in range(len(points)):
                if not v[i]:
                    new_dist = abs(points[cur][0] - points[i][0]) + abs(points[cur][1] - points[i][1])
                    if new_dist < dist[i]:
                        dist[i] = new_dist
                        heappush(q, (new_dist, i))

        return costs
        