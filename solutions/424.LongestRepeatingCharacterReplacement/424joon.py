class Solution:
    def characterReplacement(self, s: str, k: int) -> int:

        char_hash = {}
        longest = 1
        maxf = 0
        l = 0

        for r in range(len(s)):

            char_hash[s[r]] = char_hash.get(s[r] , 0 ) + 1

            maxf = max(maxf , char_hash[s[r]])

            if  maxf + k < r - l + 1:

                char_hash[s[l]] -=1
                l +=1

            longest = max(longest , r - l + 1 )

        return longest
