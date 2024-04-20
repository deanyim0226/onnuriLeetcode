class Solution {
    public int lastStoneWeight(int[] stones) {
        // find the two heaviest

        // do x-y and absolute value

        // replace in heavier spot

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for(int stone : stones)
        {
            maxHeap.add(-stone);
        }
           

        while(maxHeap.size() > 1)
        {
            int s1 = -maxHeap.remove();
            int s2 = -maxHeap.remove();

            if(s1 != s2)
                maxHeap.add(- (s1-s2));
        }
        
        return maxHeap.isEmpty() ? 0 : -maxHeap.remove();
    }
}