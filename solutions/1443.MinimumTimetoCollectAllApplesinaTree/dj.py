class Solution:
    def minTime(self, n: int, edges: list[list[int]], hasApple: list[bool]) -> int:
        v = [False] * n
        graph = [[] for _ in range(n)]
        for w, u in edges:
            graph[w].append(u)
            graph[u].append(w)

        v[0] = True
        needs = [False] * n

        def update(cur, graph, v, needs, hasApple):
            if hasApple[cur]:
                needs[cur] = True
            for nxt in graph[cur]:
                if not v[nxt]:
                    v[nxt] = True
                    child_result = update(nxt, graph, v, needs, hasApple)
                    needs[cur] = needs[cur] or child_result
            return needs[cur]
            
        update(0, graph, v, needs, hasApple)

        v = [False] * n
        v[0] = True
        def walk(cur, graph, v, needs):
            local_total = 0
            for nxt in graph[cur]:
                if not v[nxt] and needs[nxt]:
                    v[nxt] = True
                    local_total += 2 + walk(nxt, graph, v, needs)
            return local_total
        
        return walk(0, graph, v, needs)
