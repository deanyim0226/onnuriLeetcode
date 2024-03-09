class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:

        def dfs(current):

            if not current:
                return None

            current.left , current.right = dfs(current.right) , dfs(current.left)

            return current



        return dfs(root)