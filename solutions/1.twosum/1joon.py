from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        number_to_index = {}

        for index , number in enumerate(nums):

            if (target - number) in number_to_index:

                return [ number_to_index[target - number] , index ]

            number_to_index[number] = index

solution_instance = Solution()

print(solution_instance.twoSum( [2,7,11,15] , 9) )
print(solution_instance.twoSum( [2,7,11,15] , 26) )
