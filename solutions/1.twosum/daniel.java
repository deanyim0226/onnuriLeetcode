class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        /*
        need to find two elements in the given array such that the sum of two elements is equal to the target value
        I am going to use map data structure since I can retrieve and store data in o(1) time 
        while iterating array, I can store element as a value and index as a key
        if we know the difference between target value and each of elements, and map contains that difference,
        we can find the two elements that sum up to the target value. 
       
        Time complexity of this algorithm is o(n) where n is a number of elements in array.
        Space complexity of this algorithm is also o(n) since we use hashmap to store the elements of array

        */

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int answer[] = new int[2];

        for(int i = 0; i < nums.length; ++i){

            int difference = target - nums[i];

            if(map.containsKey(difference) && i != map.get(difference)){
                answer[0]= i;
                answer[1] = map.get(difference);
                return answer;

            }else{
                map.put(nums[i],i);
            }
        }

        return answer;
    }
}