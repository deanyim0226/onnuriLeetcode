class KthLargest {

    private int size;
    private PriorityQueue<Integer> pQueue;

    public KthLargest(int k, int[] nums) {

        this.size = k;
        this.pQueue = new PriorityQueue<>();

        for(int i =0; i <nums.length; i++){
            this.pQueue.add(nums[i]);
        }    

    }
    
    public int add(int val) {
        this.pQueue.add(val);
        while(this.pQueue.size() > this.size){
            this.pQueue.poll();
        }

        return pQueue.peek();

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */