from typing import List

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:

        if len(nums) ==0:
            return 0

        tracker = set(nums)

        longest = 1
        for number in nums:

            # if this number is a beginning
            if (number -1) not in tracker:
                i = 0
                while (number + i) in tracker:
                    i +=1

                longest = max(longest ,i )

        return longest
