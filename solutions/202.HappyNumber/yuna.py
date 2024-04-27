class Solution:
    def isHappy(self, n: int) -> bool:
        ans = str(n)
        arr = []

        while int(ans) != 1:
            nxt = 0
            for i in str(ans):
                nxt += int(i)**2
            ans = nxt
            if ans in arr: return False
            arr.append(ans)
        
        return True