class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:

        if len(s1) > len(s2):
            return False

        s1List = [0]*26
        s2List =[0]*26

        i = 0
        while i < len(s1):

            s1List[ord(s1[i]) - ord('a')] +=1
            s2List[ord(s2[i]) - ord('a')] +=1
            i +=1

        matches = 0
        for x in range(26):
            if s1List[x] == s2List[x]:
                matches +=1


        l = 0
        for r in range(len(s1) , len(s2)):

            if matches ==26:
                return True

            index = ord(s2[r]) - ord('a')

            s2List[index] +=1

            if s1List[index] == s2List[index]:
                matches +=1
            elif s1List[index] + 1 == s2List[index]:
                matches -=1


            index = ord(s2[l]) - ord('a')

            s2List[index] -=1

            if s1List[index] == s2List[index]:
                matches +=1
            elif s1List[index] - 1 == s2List[index]:
                matches -=1

            l +=1

        return matches ==26
