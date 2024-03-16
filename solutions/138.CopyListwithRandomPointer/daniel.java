/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    public Node recursion(Node head, HashMap<Node,Node> visited){
        if(head == null){
            return null;
        }

        if(!visited.containsKey(head)){
            
            Node newNode = new Node(head.val);
            visited.put(head,newNode);

            newNode.next = recursion(head.next,visited);
            newNode.random = recursion(head.random,visited);

            return newNode;
        }else{
            
            return visited.get(head);
        }
    }
    public Node copyRandomList(Node head) {
        
        HashMap<Node,Node> visited = new HashMap<>();
        Node node = recursion(head,visited);
        return node;
    }
}