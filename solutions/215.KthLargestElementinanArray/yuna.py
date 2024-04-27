class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if len(nums) < 1: return nums[0]

        for i in range(1, len(nums)):
            for j in range(i, 0, -1):
                if nums[j] < nums[j-1]:
                    nums[j-1], nums[j] = nums[j], nums[j-1]
        
        return nums[len(nums)-k]

        


        