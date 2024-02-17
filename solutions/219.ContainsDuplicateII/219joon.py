from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:



        tracker_for_window = set()

        l = 0

        for r in range(len(nums)):

            if nums[r] in tracker_for_window:
                return True


            tracker_for_window.add(nums[r])

            if  k < r - l + 1 :
                tracker_for_window.remove(nums[l])
                l+=1


        return False


