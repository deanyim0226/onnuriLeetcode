class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:

        max_diameter = 0

        def depth(node ):

            nonlocal max_diameter

            if not node:
                return 0


            left_depth = depth(node.left  )
            right_depth = depth(node.right )


            max_diameter = max(max_diameter , left_depth + right_depth)

            return max(left_depth , right_depth ) + 1


        depth(root )

        return max_diameter 