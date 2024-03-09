class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:


        def dfs(current):

            #baase case

            if current is None:
                return 0


            return max(dfs(current.left) , dfs(current.right)) +1

        return dfs(root)