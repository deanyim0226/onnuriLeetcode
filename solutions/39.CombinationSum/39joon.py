class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        answer = []
        def dfs(current,current_sum,index):

            #base
            if index == len(candidates) or current_sum > target:
                return
            elif current_sum == target:
                answer.append(current.copy())
                return

            #recursion
            current.append(candidates[index])
            dfs(current , current_sum +  candidates[index] , index)
            current.pop()
            dfs(current,current_sum,index+1)

        dfs([],0,0)

        return answer
