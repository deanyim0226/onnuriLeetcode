# binary tree, distinct value
# 
def solve(root, arr):
    ans = []
    arr = set(arr)

    # return arr
    def match(node, parent, cont):
        if not node:
            return []
        local_ans = []
        
        if not cont:
            local_ans.append(node)

        if node.val not in arr:
            left_ans = match(node.left, node, True)
            right_ans = match(node.right, node, True)
        else:
            if parent and node.val == parent.left.val:
                parent.left = None
            elif parent and node.val == parent.right.val:
                parent.right = None
            left_ans = match(node.left, node, False)
            right_ans = match(node.right, node, False)
            #left = [6], right[7]

        # local = [1], left = [], right = [6, 7]
        return local_ans + left_ans + right_ans

    return match(root, None, False)