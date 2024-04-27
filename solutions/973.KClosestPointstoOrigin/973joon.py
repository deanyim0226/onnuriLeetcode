class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:

        answer = [ ]
        array_with_distance = [ ]

        for point in points:
            array_with_distance.append( [ point , point[0]**2 + point[1]**2 ])


        array_with_distance.sort( key = lambda x : x[1])


        for i in range(k):
            answer.append(array_with_distance[i][0])

        return(answer)
