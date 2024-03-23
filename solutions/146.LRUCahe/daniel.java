class LRUCache {
 
    private HashMap<Integer,Integer> map;
    private int size;
    private Deque<Integer> deque;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        this.deque = new ArrayDeque<>();
    }
    
    public int get(int key) {

        if(this.map.containsKey(key)){
            this.deque.remove(key);
            this.deque.addFirst(key);
            return this.map.get(key);
        }
        return -1;
       //return this.map.containsKey(key) ? this.map.get(key) : -1;
    }


    public void put(int key, int value) {
        
        if(this.map.containsKey(key)){
            this.deque.remove(key);
            this.deque.addFirst(key);
        }else{
            this.deque.addFirst(key);
            if(this.deque.size() > this.size){
                int deleteVal = this.deque.pollLast();
                this.map.remove(deleteVal);
            }
  
        }
        this.map.put(key,value);
        


    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */