class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i =0; i < nums.length; i++){
            pQueue.add(nums[i]);

            if(pQueue.size() > k){
                pQueue.poll();
            }
        }

        return pQueue.peek();
    }
}