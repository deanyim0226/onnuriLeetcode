class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        cnt_zero = 0
        min_indexes = {}
        min_indexes[0] = -1
        ans = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                cnt_zero += 1
            else:
                cnt_zero -= 1
            
            if cnt_zero in min_indexes:
                ans = max(ans, i - min_indexes[cnt_zero])
            else:
                min_indexes[cnt_zero] = i
        return ans

#O(n), O(n)