
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':

        oldToNew = {}

        def clone(node):

            if node in oldToNew:
                return oldToNew[node]


            copy = Node(node.val)
            oldToNew[node] = copy
            for nei in node.neighbors:
                copy.neighbors.append(clone(nei))

            return copy

        return clone(node) if node else None
