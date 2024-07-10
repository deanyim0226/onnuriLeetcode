class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        inGraph = [0] * n
        for u, v in edges:
            inGraph[v] += 1
        ans = []
        for i in range(n):
            if inGraph[i] == 0:
                ans.append(i)
        
        return ans