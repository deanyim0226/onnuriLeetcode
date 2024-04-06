/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node dfs(Node node, HashMap<Node,Node> map){
        if(node == null){
            return null;
        }

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node copyNode = new Node(node.val, new ArrayList<>());
        map.put(node,copyNode);

        for(Node neighbor: node.neighbors){
            Node n = dfs(neighbor,map);
            copyNode.neighbors.add(n);
        }

        return copyNode;
    }
 
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map = new HashMap<>();
        return dfs(node,map);
    }
}