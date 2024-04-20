
import heapq
class KthLargest:

    def __init__(self, k: int, nums: List[int]):

        self.minheap = nums
        self.k = k

        # this is a min heap
        heapq.heapify(self.minheap)

        while len(self.minheap) > self.k:
            heapq.heappop(self.minheap)

        # here now we have k largest elements beacsue we have popped


    def add(self, val: int) -> int:


        heapq.heappush(self.minheap , val)

        if len(self.minheap) > self.k:
            heapq.heappop(self.minheap)
        return self.minheap[0]





