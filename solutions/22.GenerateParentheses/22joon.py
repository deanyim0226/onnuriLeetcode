from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:

        answer = []


        def dfs(current,open,closed):
            #base
            nonlocal answer
            if closed > open or open >n:
                return

            if len(current) == 2*n:
                answer.append(current)
                return


            #recursion
            dfs(current + "(" , open + 1 , closed  )
            dfs(current+")" , open  , closed + 1)

        dfs( "" , 0 , 0)
        return answer