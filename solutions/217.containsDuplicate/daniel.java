class Solution {
    public boolean containsDuplicate(int[] nums) {

        /*
        we just need to find duplicate value in array
        we can use hashmap to store each element in array as a value and frequency as a key 
        if the frequency is greater than 1, we know that it contains duplicate value

        time complexity is o(n) where n is a number of elements in array
        space complexity is o(n) since we store elements of array into map  
        */
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