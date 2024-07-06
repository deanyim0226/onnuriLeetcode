class Node{
    
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }
}
class MyLinkedList {

    Node head;
    int size;

    public MyLinkedList() {  
        this.size = 0;
        this.head = new Node(-1);
    }

    public int get(int index) {
        
        if(this.size <= index){
            return -1;
        }else{

            int count = 0;
            Node curr = this.head.next;

            while(curr != null){
        
                if(index == count){
                    return curr.val;
                }
                count += 1;
                curr = curr.next;
            }
            return -1;
        }
    }
    
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(this.size,val);
    }
    
    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        if(index == 0){
            if(this.size == 0){
                this.head.next = newNode;
            }else{
                Node firstNode = this.head.next;
                this.head.next = newNode;
                newNode.next = firstNode;
            }
            this.size += 1;
        }else if(this.size == index){
            Node curr = this.head.next;

            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
            this.size += 1;
        }else if(this.size < index){

        }else{
            Node curr = this.head.next;
            Node prev = null;
            int count = 0;
            while(curr != null){
                if(count == index){
                 
                    prev.next = newNode;
                    newNode.next = curr;
                    this.size += 1;
                    break;
                }
                count += 1;
                prev = curr;
                curr = curr.next;
            }
            
        }
    }
    
    public void deleteAtIndex(int index) {
   
        if(this.size > index){
            if(index == 0){
                Node firstNode = this.head.next;
                Node nextNode = firstNode.next;
                this.head.next = nextNode;
                
            }else if(this.size-1 == index){
                Node curr = this.head.next;
                Node prev = null;
                while(curr.next != null){
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = null;
            }else{
                Node curr = this.head.next;
                Node prev = null;
                int count = 0;

                while(curr != null){
                   
                    if(count == index){
                        Node nextNode = curr.next;
            
                        prev.next = nextNode;
                        break;
                    }
                    count += 1;
                    prev = curr;
                    curr = curr.next;
                }
            }

            this.size -= 1;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */