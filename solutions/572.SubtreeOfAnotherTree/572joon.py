# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:

        def helper(starting_root , subRoot):

            if not subRoot:
                return True

            if not starting_root:
                return False

            if self.isSameTree(starting_root, subRoot):
                return True

            return helper(starting_root.left,subRoot ) or helper(starting_root.right, subRoot)

        return helper(root, subRoot)


    def isSameTree( self, root , subRoot ):


        def dfs(left_tree , right_tree):

            if not left_tree and right_tree:
                return False

            if left_tree and not right_tree:
                return False

            if not left_tree and not right_tree:
                return True

            # passed all edge cases
            if left_tree.val != right_tree.val:
                return False
            else:
                return dfs(left_tree.left, right_tree.left) and dfs(left_tree.right, right_tree.right)

        return dfs(root , subRoot)
