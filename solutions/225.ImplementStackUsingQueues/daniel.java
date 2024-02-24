class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;
    
    public MyStack() {
 
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
        this.top = 0;
    }
    
    public void push(int x) {
        
        this.queue1.add(x);
        this.top = x;
    }
    
    public int pop() {
        
        int returnVal = this.top;
        while(this.queue1.size() != 1){
            int dequeueVal = this.queue1.poll();
            this.queue2.add(dequeueVal);
            this.top = dequeueVal;
        }
        this.queue1.poll();

        while(!this.queue2.isEmpty()){
            int dequeueVal = this.queue2.poll();
            this.queue1.add(dequeueVal);
        }
        
        return returnVal;
    }
    
    public int top() {
        return this.top;
    }
    
    public boolean empty() {
        return this.queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */