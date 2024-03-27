class Solution {
    
    public void backtracking(int[] nums, int start, List<Integer> list, List<List<Integer>> ans, HashSet<List<Integer>> set){

        if(!set.contains(list)){
            set.add(list);
            ans.add(new ArrayList<>(list));
        }

        for(int i= start; i < nums.length; i++){
            list.add(nums[i]);
            backtracking(nums,++start,list,ans,set);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtracking(nums,0,list,ans,set);
        return ans;
    }
}