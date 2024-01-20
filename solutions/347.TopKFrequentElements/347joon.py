from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        result = []
        count = {}
        freq = [ [] for i in range(len(nums) + 1) ]

        # initialize hashmap
        for num in nums:
            count[num] = 1 + count.get(num,0)

        #Bucket Sort -> O(N)
        for n , c in count.items():
            freq[c].append(n)

        for i in range(len(freq) -1 , 0 , -1):
            for number in freq[i]:
                result.append(number)
                if len(result) ==k:
                    return result

solution_instance = Solution()
nums = [1,1,1,2,2,3]
k = 2

print(solution_instance.topKFrequent(nums, k))
