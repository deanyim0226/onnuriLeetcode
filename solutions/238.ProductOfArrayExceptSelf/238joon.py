from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        lefties = [1]*len(nums)
        righties = [1]*len(nums)
        answer_array = [None]*len(nums)

        for i in range(1, len(nums)):

            lefties[i] = nums[i-1]*lefties[i-1]

        for j in range(len(nums)-2, -1, -1):

            righties[j] = nums[j+1]*righties[j+1]

        for k in range(len(answer_array)):

            answer_array[k] = lefties[k]*righties[k]

        return answer_array

