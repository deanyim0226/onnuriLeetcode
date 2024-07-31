class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        ans = 0
        fst = snd = -1
        fst_cnt = snd_cnt = 0
        lo, hi = 0, 0
        while hi < len(fruits):
            if fruits[hi] not in [fst, snd]:
                if fst == -1:
                    fst = fruits[hi]
                    fst_cnt = 1
                elif snd == -1:
                    snd = fruits[hi]
                    snd_cnt = 1
                else:
                    while fst_cnt > 0 and snd_cnt > 0:
                        if fruits[lo] == fst:
                            fst_cnt -= 1
                        else:
                            snd_cnt -= 1
                        lo += 1
                    if fst_cnt == 0:
                        fst = fruits[hi]
                        fst_cnt = 1
                    else:
                        snd = fruits[hi]
                        snd_cnt = 1
            else:
                if fruits[hi] == fst:
                    fst_cnt += 1
                else:
                    snd_cnt += 1
            ans = max(ans, hi - lo + 1)
            hi += 1
        return ans
    
#Runtime N, Space 1