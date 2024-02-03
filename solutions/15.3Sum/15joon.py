from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        answer = []
        nums.sort()
        for index, number in enumerate(nums):

            if index >0 and number == nums[index-1]:
                continue
            left , right = index + 1 , len(nums) -1
            while left < right:

                threesum = nums[index] + nums[left] + nums[right]

                if threesum > 0 :
                    right -= 1

                elif threesum <0:
                    left +=1

                else:
                    answer.append([nums[index] , nums[left] , nums[right]])

                    while left < right and nums[left] == nums[left + 1 ]:
                        left +=1

                    left +=1
                    right -=1

        return answer
