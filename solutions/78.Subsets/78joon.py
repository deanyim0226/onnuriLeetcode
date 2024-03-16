class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        answer = [ ]

        def dfs(current , i ):

            nonlocal answer

            #base case

            if i == len(nums) :
                answer.append(current.copy())
                return

            current.append(nums[i])
            dfs(current , i+1)
            current.pop()
            dfs(current, i + 1 )


        dfs([] , 0 )

        return answer
        