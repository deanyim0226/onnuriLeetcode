class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def addSum(node, cur):
            nonlocal ans
            cur = cur * 10 + node.val
            if not node.left and not node.right:
                ans += cur
                return
            if node.left:
                addSum(node.left, cur)
            if node.right:
                addSum(node.right, cur)
        
        addSum(root, 0)
        return ans