class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        lo, hi = 0, len(nums)
        while lo <= hi:
            mid = (lo + hi) // 2

            left = nums[mid - 1] if mid > 0 else -float('inf')
            right = nums[mid + 1] if mid < len(nums) - 1 else -float('inf')
            if left < nums[mid] and right < nums[mid]:
                return mid
            elif left > nums[mid]:
                hi = mid - 1
            else:
                lo = mid + 1
        return -1