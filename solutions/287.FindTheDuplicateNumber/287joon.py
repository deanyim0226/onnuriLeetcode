class Solution:
    def findDuplicate(self, nums: List[int]) -> int:

        nums.sort()

        prev = nums[0]
        i = 1

        while i != len(nums):

            if prev == nums[i]:
                return prev

            prev = nums[i]
            i +=1
