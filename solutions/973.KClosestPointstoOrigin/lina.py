class Solution(object):
    def kClosest(self, points, k):

        # time: O(n log n)
        # space: O(n)

        def getDistance(pair):
            # distance method from pair to 0,0
            return math.sqrt((pair[0])*(pair[0])+(pair[1])*(pair[1]))

        result = []

        distances = dict()

        for pair in points:
            distance = getDistance(pair)
            if distance not in distances:
                distances[distance] = []
            distances[distance].append(pair)

        keys = list(distances.keys())

        heapq.heapify(keys) # O(n)

        length = len(result)

        while length < k: # O(n)
            lst = heapq.heappop(keys) #O(log n)
            for pair in distances.get(lst):
                result.append(pair)
            length = len(result)


        return result



