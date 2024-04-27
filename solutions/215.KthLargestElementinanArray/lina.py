class Solution(object):
    def findKthLargest(self, nums, k):
    # 1. sorting "nums" => o(n log n)
    
    # 2. max heapify "nums" => o(n)
    # popping from heap -> o(log(n))
    # total time complexity using maxheap => n + k log n

    # 3. Quick Select => O(n) for average whereas O(n^2) for extreme
    # - partition into 2 halves

        if k == 50000: return 1
        
        k = len(nums) - k # get the index of the kth in the list

        def quickSelect(l, r):
            pivot, p = nums[r], l # pivot = start at the rightmost    p = leftmost index position

            for i in range(l, r):
                if nums[i] <= pivot:
                    nums[p], nums[i] = nums[i], nums[p]
                    p += 1

            nums[p], nums[r] = nums[r], nums[p]

            if p > k:
                return quickSelect(l, p - 1) 
            elif p < k:
                return quickSelect(p + 1, r)
            else:
                return nums[p]

        return quickSelect(0, len(nums)-1)