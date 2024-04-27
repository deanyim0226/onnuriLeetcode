class Solution(object):
    def rob(self, nums):

        return max(nums[0], self.helper(nums[1:]), self.helper(nums[:-1]))

    def helper(self, nums):
            prevMax, newMax = 0, 0

            for n in nums:
                newRob = max(prevMax + n, newMax)
                prevMax = newMax
                newMax = newRob
            return newMax
        
        