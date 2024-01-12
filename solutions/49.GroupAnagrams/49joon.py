from collections import defaultdict

from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:


        anagram_hash_table = defaultdict(list)

        for word in strs:
            # Sorting the characters of the word and joining back to form a string
            sortedWord = ''.join(sorted(word))

            # Adding the original word to the list of its sorted character representation
            anagram_hash_table[sortedWord].append(word)

        # Returning all grouped anagrams as a list
        return list(anagram_hash_table.values())


solution_instance = Solution()