from collections import defaultdict

class Solution:
    def isNStraightHand(self, hand: list[int], groupSize: int) -> bool:
        hand.sort()
        cnt_card = defaultdict(int)

        for val in hand:
            cnt_card[val] += 1
        
        for val in hand:
            if cnt_card[val] > 0:
                for i in range(groupSize):
                    if cnt_card[val + i] == 0:
                        return False
                    cnt_card[val + i] -= 1
        
        return True