class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i < stones.length; i++){
            pQueue.add(stones[i]);
        }

        while(pQueue.size() > 1){
            int heaviest = pQueue.poll();
            int secondHeaviest = pQueue.poll();

            if(heaviest != secondHeaviest){
                int newWeight = heaviest - secondHeaviest;
                pQueue.add(newWeight);
            }
        }

        if(pQueue.size() == 0){
            return 0;
        }
        return pQueue.peek();
    }
}