import heapq
# from typing import List  # Correct the import for List type hint

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        # Negate stones to simulate a max-heap in Python's min-heap structure
        negated_stones = [-x for x in stones]

        # In-place transform the list into a heap
        heapq.heapify(negated_stones)  # heapify modifies the list in-place

        # Process the heap until one or zero stones remain
        while len(negated_stones) > 1:
            largest = -heapq.heappop(negated_stones)  # Correct the function name to heappop
            second_largest = -heapq.heappop(negated_stones)

            if largest != second_largest:  # Only push the difference if it is non-zero
                heapq.heappush(negated_stones, -(largest - second_largest))

        # Return the weight of the last stone or 0 if no stones are left
        return -negated_stones[0] if negated_stones else 0
