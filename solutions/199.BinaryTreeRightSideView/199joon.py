# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        result = [ ]

        queue = deque([root])

        while queue:

            rightside = None

            for i in range(len(queue)):

                current = queue.popleft()

                if current:

                    rightside = current
                    queue.append(current.left)
                    queue.append(current.right)

            if rightside:
                result.append(rightside.val)

        return result
