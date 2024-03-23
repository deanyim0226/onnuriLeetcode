# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        result = [ ]
        queue = deque([root])

        #current_layer = [ ]
        while queue:

            current_layer = [ ]

            for i in range(len(queue)):

                current = queue.popleft()

                if current:
                    current_layer.append(current.val)
                    queue.append(current.left)
                    queue.append(current.right)

            if len(current_layer) !=0:

                result.append(current_layer)

        return result