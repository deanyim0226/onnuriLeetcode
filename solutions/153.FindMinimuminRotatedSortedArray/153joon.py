class Solution:
    def findMin(self, nums: List[int]) -> int:

        answer = float("inf")
        l , r = 0 , len(nums) -1

        while l <= r:
            # if the array turns out to be sorted then return
            if nums[l] < nums[r]:
                answer = min(answer,nums[l])
                break

            m = (l + r)//2

            answer = min(answer , nums[m])

            # this means that m is part of LEFT portion, so should search right side
            if nums[m] >= nums[l]:

                l = m +1

            else:

                r = m -1

        return answer