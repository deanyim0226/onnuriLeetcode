class Solution {


    public void backtracking(List<List<Integer>> ans, List<Integer> subset, int[] nums, int start){
        
        ans.add(new ArrayList(subset));
    
        for(int i = start; i < nums.length; i++){
    
            subset.add(nums[start]);
            backtracking(ans, subset,nums,++start);
            subset.remove(subset.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtracking(ans,subset,nums,0);
        
        return ans;

    }
    
}