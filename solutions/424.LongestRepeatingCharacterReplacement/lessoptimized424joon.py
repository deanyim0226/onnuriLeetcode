class Solution:
    def characterReplacement(self, s: str, k: int) -> int:

        char_hash = {}

        longest = 1


        l = 0
        for r in range(len(s)):

            char_hash[s[r]] = char_hash.get(s[r] , 0 ) + 1

            if  max(char_hash.values()) + k < r - l + 1:

                char_hash[s[l]] -=1
                l +=1

            longest = max(longest , r - l + 1 )


        return longest