class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:

        number_used = set()

        answer = []
        current_set = []

        def dfs(current_set , number_used  ):

            #base
            if len(current_set) == len(nums):
                answer.append(current_set.copy())
                return

            # recursion
            for number in nums:
                if number not in number_used:
                    number_used.add(number)
                    current_set.append(number)
                    dfs(current_set ,number_used  )
                    number_used.remove(number)
                    current_set.pop()


        dfs([] , number_used)
        return answer