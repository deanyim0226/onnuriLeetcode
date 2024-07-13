class Solution {
    
    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> curr, Map<Integer,Integer> map){

        if(curr.size() == nums.length){

            ans.add(new ArrayList<>(curr));
            return;
        }

        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            int key = entry.getKey();
            int frequency = entry.getValue();

            if(frequency == 0){
                continue;
            }

            curr.add(key);
            map.put(key,frequency - 1);
            
            helper(nums,ans,curr,map);

            curr.remove(curr.size()-1);
            map.put(key,frequency);

        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            int occurrence = map.getOrDefault(nums[i],0);
            map.put(nums[i], ++occurrence);
        }

        List<Integer> curr = new ArrayList<>();
        helper(nums,ans,curr,map);
      
        return ans;
    }
}