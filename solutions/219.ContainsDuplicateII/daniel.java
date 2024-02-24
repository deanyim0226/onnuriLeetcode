class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        

        /*
        map to store element and its position 
        whenever we have encounterd the same element 
        we update position and if the abs value pos - i is less than equal to k 
        retur true otherwise false
        */
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int pos = map.get(nums[i]);

                if(Math.abs(pos-i) <= k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }

        return false;
    }
}