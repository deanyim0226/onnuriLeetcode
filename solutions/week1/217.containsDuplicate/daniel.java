class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i =0; i < nums.length; ++i){

            if(map.containsKey(nums[i])){
                int currentVal = map.get(nums[i]);
                map.put(nums[i], currentVal+1);
                return true;
            }else{
                map.put(nums[i],1);
            }
        }

        return false;
    }
}