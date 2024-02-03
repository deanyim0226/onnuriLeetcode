class Solution(object):
    def reverseString(self, s):


        how_long = len(s)


        for i in range(how_long//2) :

            s[i] , s[len(s) - 1 - i  ] = s[len(s) -1 - i ], s[i]