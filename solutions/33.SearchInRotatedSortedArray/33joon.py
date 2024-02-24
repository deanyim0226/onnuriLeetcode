class Solution:
    def search(self, nums: List[int], target: int) -> int:

        l ,r = 0 , len(nums) - 1


        while l <=r:

            mid =(l+r)//2

            if target == nums[mid]:
                return mid

                # figuring out where the middle portion is located is the point for this problem

            # if the middle is in left sorted portion

            # this line checks where the mid falls under
            if  nums[l] <= nums[mid]:


                # if we think that the target lives in righter part of the left portion OR
                # the target livs on the right sorted portion
                if nums[mid] < target or target < nums[l]:

                    l = mid + 1

                else:

                    r = mid -1


                    # if the middle is in thje right sorted portion


            else:
                # if the target seems to be in the right sorted portion BUT in the lefter side
                # of the right sorted portion

                if target > nums[r] or nums[mid] > target:
                    r = mid -1

                else:

                    l = mid + 1


        return -1 