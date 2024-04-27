class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:

        pq = []

        heapq.heapify(pq)

        for number in nums:
            heapq.heappush(pq , -number)


        i = 0
        while i !=k-1:
            heapq.heappop(pq)

            i +=1

        return -pq[0]


