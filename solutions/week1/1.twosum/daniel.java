class Solution {
    public int[] twoSum(int[] nums, int target) {

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