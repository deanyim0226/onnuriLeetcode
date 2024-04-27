class Solution:
    def rob(self, nums: List[int]) -> int:

        def rob_linear(houses):
            if not houses:
                return 0
            if len(houses) == 1:
                return houses[0]

            max_rob = [0] * len(houses)
            max_rob[0] = houses[0]
            max_rob[1] = max(houses[0], houses[1])

            for i in range(2, len(houses)):
                max_rob[i] = max(houses[i] + max_rob[i - 2], max_rob[i - 1])

            return max_rob[-1]

        if not nums:
            return 0

        # If there's only one house, you can only rob that one.
        if len(nums) == 1:
            return nums[0]

        # Run the dynamic programming solution twice:
        # Once excluding the first house and once excluding the last house.
        return max(rob_linear(nums[1:]), rob_linear(nums[:-1]))
