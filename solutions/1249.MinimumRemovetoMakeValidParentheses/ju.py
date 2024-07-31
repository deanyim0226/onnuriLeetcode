class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        marker = set()
        open_cnt = []
        for i in range(len(s)):
            if s[i] == '(':
                open_cnt.append(i)
            elif s[i] == ')':
                if len(open_cnt) > 0:
                    open_cnt.pop()
                else:
                    marker.add(i)
        marker.update(open_cnt)

        ans = ""
        for i in range(len(s)):
            if i not in marker:
                ans += s[i]
        return ans

#Runtime, Memory n, n