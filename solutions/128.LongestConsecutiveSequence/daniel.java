class Solution {
    public int longestConsecutive(int[] nums) {
  
        /* Initial approach

        if(nums.length < 1){
            return 0;
        }

        //to store all
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],1);
        }

        int maxNumber = Collections.max(map.keySet());
        int minNumber = Collections.min(map.keySet());
        int longest = 0;
        int current = 0;
    
        for(int i =minNumber; i <= maxNumber; i++){
            
            if(map.containsKey(i)){
                current += 1;
                if(longest <= current){
                    longest = current;
                }
            }else{
                current = 0;
            }
        
        }

        return longest;
   */
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i <nums.length; i++){
            set.add(nums[i]);
        }

        int longest = 0;
    
        for(int i = 0; i <nums.length; i++){

            int currVal = nums[i];
            if(!set.contains(currVal-1)){
                int currentCount = 0;
                while(set.contains(currVal)){
                    
                    currVal += 1;
                    currentCount+= 1;
                }        

                if(longest < currentCount){
                    longest = currentCount;
                }
            }
            
        }

        return longest;

    }
}