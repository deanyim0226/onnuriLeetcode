class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        ans = []
        nums.sort()
        def backtrack(nums, ans, cur):
            if not nums:
                ans.append(cur)
                return
            for i in range(len(nums)):
                if i > 0 and nums[i] == nums[i - 1]:
                    continue
                backtrack(nums[:i] + nums[i + 1:], ans, cur + [nums[i]])
                
                    
        backtrack(nums, ans, [])
        return ans