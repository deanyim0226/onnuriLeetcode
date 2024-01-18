class Solution {


    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        //return k most frequent element 
        //use a map data structure to store each element as a key
        //and a value as frequency of the element 

        for(int i = 0; i < nums.length; ++i){
        
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.put(nums[i], value+1);
            }else{
                map.put(nums[i], 1);
            }
        }

        //if we sort the frequency of each element,
        //we can find k most frequent element 

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        
        for(Integer key : map.keySet()){
            int frequency = map.get(key);
            pQueue.add(frequency);
    
            if(pQueue.size()-1 == k){ 
                pQueue.poll();
            }
        }

        /*
        priority queue is maintained in a way that the size of queue is equal to k
        the feature of priority queue(min heap) sorts the frequency as we needed 
        since the min value(lowest frequency) is always stored at the root of the heap.
        */

        int[] answer = new int[pQueue.size()];
        int index = 0;

        Set<Integer> list = new HashSet<>();
        
        while(!pQueue.isEmpty()){
            
            int frequency = pQueue.poll();
            for(Integer element : map.keySet()){

                if(frequency == map.get(element)){
                    list.add(element);
                }
            }
        }

        for(Integer element : list){
            answer[index] = element;
            index += 1;
        }
    
        return answer;

    }
}