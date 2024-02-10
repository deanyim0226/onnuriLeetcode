from collections import deque

class Solution:
    def isValid(self, s: str) -> bool:

        bracket_correspond = {

            '(' : ')' ,

            '{' : '}' ,

            '[' : ']'

        }
        paran_to_be_closed = deque()

        for bracket in s :

            #if its a closing bracket
            if bracket in [")" , "}" , "]"]:

                if len(paran_to_be_closed) > 0:

                    if bracket != paran_to_be_closed.pop():
                        return False

                else: return False

            #if its an open bracket
            else:
                paran_to_be_closed.append(bracket_correspond[bracket])

        if len(paran_to_be_closed) == 0:
            return True

        else:
            return False
