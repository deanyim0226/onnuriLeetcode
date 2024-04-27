
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        mp = {}
        n = 0
        for point in points:
            dist = (point[0]**2) + (point[1]**2)
            print("dist", int(dist))
            mp[n] = dist
            print(mp)
            n += 1

        mp = sorted(mp.items(), key=lambda x: x[1])
        print("sorted: ", mp)

        ans = []
        for i in range(0, k):
            ans.append(points[mp[i][0]])

        return ans