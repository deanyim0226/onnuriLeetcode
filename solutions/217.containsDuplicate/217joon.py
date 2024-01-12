from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:

        seen_or_not = set()

        for number in nums:
            if number in seen_or_not:
                return True
            else:
                seen_or_not.add(number)

        return False

solution_instance = Solution()
nums1 = [1, 2, 3, 4]
nums2 = [1, 2, 3, 4, 1]
result1 = solution_instance.containsDuplicate(nums1)
result2 = solution_instance.containsDuplicate(nums2)
print(result1)
print(result2)



