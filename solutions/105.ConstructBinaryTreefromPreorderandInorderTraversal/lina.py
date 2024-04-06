class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Preorder (recursive)
        # 1. Reach a node -> Add node to array
        # 2. Go to left child -> Add node (repeat until no left is available) 
        # 3. Go to right child -> Add node -> Go to Step 2. 

        if not preorder or not inorder:
            return None

        root = TreeNode(preorder[0])

        # find the midpoint(root) of the left and right trees
        middle = inorder.index(preorder[0])

        root.left = self.buildTree(preorder[1:middle + 1], inorder[:middle])
        root.right = self.buildTree(preorder[middle + 1:], inorder[middle + 1:])

        return root