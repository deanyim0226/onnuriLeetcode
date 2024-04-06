class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        # Iterative Solution (also available in recursive solution)

        # the goal is to keep going as far left as you can

        # 1. add node
        # 2. go to (1) left child and (2) right child
        #   - when NULL is reached, go back to parent and POP parent node 
        #   - count how many times you pop = kth smallest value

        n = 0
        stack = []
        cur = root

        while cur or stack:
            # keep going left
            while cur:
                stack.append(cur)
                cur = cur.left

            # if cur is NULL
            cur = stack.pop()
            n = n + 1 # We popped a node, k-th value

            if n == k: # If we popped as much as k-th value
                return cur.val

            cur = cur.right # Go right because cur is NULL
        