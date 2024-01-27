from typing import List

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:

        if numRows ==1 :
            return [ [1]]

        if numRows == 2:

            return [ [1], [1 ,1 ]]

        from_three_rows = [ [1] , [1,1] ]

        i = 2
        # this loop accounts for how many arrays are appended in the answer array
        # this will run numRows -2 times because we start from 3rd array always
        while i != numRows:
            # intializes array to be appended
            currentRow = []
            last_row = from_three_rows[-1]
            added_arary = []

            for k in range(len(last_row)-1):
                added_arary.append(last_row[k] + last_row[k+1])

            currentRow = [1] + added_arary + [1]

            from_three_rows.append(currentRow)

            i +=1

        return from_three_rows
