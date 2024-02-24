# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:

        l1 = list1

        l2 = list2

        x = ListNode()

        dummy = x

        def dfs(node):

            nonlocal l1, l2 , x

            if not l1:
                node.next = l2
                return

            elif not l2:
                node.next = l1
                return

            if node is None:
                return

            if l1.val >= l2.val:

                node.next = l2
                l2=l2.next

            else:

                node.next = l1
                l1 = l1.next

            dfs(node.next)

        dfs(x)
        return dummy.next