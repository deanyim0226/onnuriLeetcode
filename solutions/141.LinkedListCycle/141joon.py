# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:

        seen_or_not = set()

        current = head

        while current:

            if current in seen_or_not:
                return True

            seen_or_not.add(current)
            current = current.next

        return False