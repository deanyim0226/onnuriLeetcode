class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        paths = []
        def dfs(node, path, v, dest):
            if not node:
                return
            path.append(node)
            if node.val in dest:
                paths.append(path[:])
            if node.left and node.left.val not in v:
                v.add(node.left.val)
                dfs(node.left, path, v, dest)
                v.remove(node.left.val)
            if node.right and node.right.val not in v:
                v.add(node.right.val)
                dfs(node.right, path, v, dest)
                v.remove(node.right.val)
            path.pop()
            return

        dfs(root, [], set(), [p.val, q.val])

        idx = 0
        while idx < min(len(paths[0]), len(paths[1])):
            if paths[0][idx].val != paths[1][idx].val:
                break
            idx += 1
        
        return paths[0][idx - 1]
