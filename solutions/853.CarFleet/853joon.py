class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:

        pair_list = [ [p , s] for p ,s in zip(position , speed) ]

        stack = []


        for p, s  in sorted(pair_list)[::-1]: # reverse sorted

            arrival_time = (target - p) / s

            stack.append(arrival_time)

            #this means the new one will catch up to the slower one ahead
            if len(stack) >=2 and stack[-1] <= stack[-2]:
                stack.pop()


        return len(stack)