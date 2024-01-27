from typing import List

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:

        answer = ""
        i = 0
        while i != len(strs[0]):

            this_time_around = strs[0][:i+1]

            for word in strs:

                if word[:i+1] != this_time_around:
                    return strs[0][:i] if i >0 else ""

            i +=1

        return strs[0][:i]
