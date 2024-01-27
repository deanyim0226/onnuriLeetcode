from typing import List

class Solution:
    def majorityElement(self, nums: List[int]) -> int:

        threshold = len(nums)/2

        number_count = {}

        for number in nums:
            number_count[number] = 1 + number_count.get(number,0)

            if number_count[number] > threshold:
                return number
