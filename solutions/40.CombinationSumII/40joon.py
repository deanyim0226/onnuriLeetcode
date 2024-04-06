class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:

        candidates.sort()
        answer = [ ]

        current = [ ]

        def backtracking( current , current_sum , index ):

            #base case
            if current_sum == target:
                answer.append(current.copy())
                return

            if index >= len(candidates) or current_sum > target:
                return


            # recursion case
            current.append(candidates[index])
            backtracking(current, current_sum + candidates[index] , index + 1  )
            current.pop()
            while index < len(candidates) -1 and candidates[index] == candidates[index+1]:
                index +=1
            backtracking(current , current_sum , index + 1 )

        backtracking([] , 0 , 0 )
        return answer





