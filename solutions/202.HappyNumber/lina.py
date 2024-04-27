class Solution(object):
    def isHappy(self, n):
        
        visited = set()

        def sumSquare(num):
            strNum = str(num)
            sum = 0
            for i in range(len(strNum)):
                integer = int(strNum[i])
                sum += integer * integer
            
            return sum
        
        sum = sumSquare(n)

        while sum != 1 and sum not in visited:
            visited.add(sum)
            sum = sumSquare(sum)
        
        if sum == 1:
            return True
        else:
            return False



        