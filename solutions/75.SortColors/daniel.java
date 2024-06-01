class Solution {
    public void sortColors(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            int curr = nums[i];
            if(map.containsKey(curr)){
                int freq = map.get(curr);
                map.put(curr,++freq);
            }else{
                map.put(curr,1);
            }
        }

        int index =0;
        for(int i =0; i < 3; i++){
            if(map.containsKey(i)){
                int count = map.get(i);
                while(count != 0){
                    nums[index] = i;
                    index += 1;
                    count -= 1;
                }
            }
        }

     
    }
}