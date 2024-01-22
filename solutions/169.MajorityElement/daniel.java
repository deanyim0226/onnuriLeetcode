class Solution {
    public int majorityElement(int[] nums) {
        
        //find the majority element, which appears more than n/2 times

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; ++i){

            if(map.containsKey(nums[i])){
                int currVal = map.get(nums[i]);
                map.put(nums[i], currVal+1);
            }else{
                map.put(nums[i], 1);
            }
        }

        int standardPoint = nums.length / 2;
        for(Integer key : map.keySet()){

            if(standardPoint < map.get(key)){
                return key;
            }
        }

        return -1;
    }
}