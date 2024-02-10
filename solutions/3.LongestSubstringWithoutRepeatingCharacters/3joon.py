class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        if len(s) == 0 :
            return 0

        longest = 1

        seen_or_not = set()

        l = 0
        r = 1
        seen_or_not.add(s[l])

        while r < len(s):

            if s[r] in seen_or_not:

                # we just located a letter we have seen before
                # s[r] in seen_or_not
                # "abcdefcas"
                #  l     r
                while s[l] != s[r]:
                    seen_or_not.remove(s[l])
                    l +=1
                l +=1

            seen_or_not.add(s[r])
            longest = max(longest , r - l + 1 )
            r +=1

        return longest