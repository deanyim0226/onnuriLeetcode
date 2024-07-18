class Solution:
    def maxLength(self, arr: List[str]) -> int:
        ans = 0
        checked = [False] * 26
        filtered = []
        for elem in arr:
            if len(set(elem)) == len(elem):
                filtered.append(elem)
        def charToInt(ch):
            return ord(ch) - ord('a')
        
        def backtrack(arr, idx, checked):
            nonlocal ans
            if idx == len(arr):
                ans = max(ans, sum(checked))
            for i in range(idx, len(arr)):
                s = arr[i]
                repeated = False
                for ch in s:
                    if checked[charToInt(ch)]:
                        repeated = True
                        break
                if not repeated:
                    for ch in s:
                        checked[charToInt(ch)] = True
                    backtrack(arr, i + 1, checked)
                    for ch in s:
                        checked[charToInt(ch)] = False
                else:
                    backtrack(arr, i + 1, checked)
                
        backtrack(filtered, 0, checked)
        return ans