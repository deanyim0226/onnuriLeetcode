class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:

        answer = [ ]
        nums.sort()
        def dfs(current , index):
            nonlocal answer
            #base case
            if index == len(nums):
                answer.append(current[::])
                return
            #[1,2,2,2,3,3]
            #[1] ==>
            #recursion case [1,2]--> [1,2,2]]
            #.                    --> [1,2,3]

            #.                [1,2,2]. ==>.  [1,2,2,2]
            # => [1,2,2,2,3]

            #                          ==>  [1,2,2,3]

            #                             ==> [1,2,2,3,3]
            #                             ==> [1,2,2,3]
            #                  [1,2,3] ==> [1,2,3,3]
            #====[1,2,3] ended
            #
            #.
            #[1,3]
            current.append(nums[index])
            dfs(current,index+1)
            current.pop()

            while index < len(nums)-1 and nums[index] == nums[index+1]:
                index +=1
            dfs(current, index+1)

        dfs([],0)
        return answer