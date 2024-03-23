class Solution {
    
    public void backtracking(List<List<Integer>> ans, List<Integer> list, int[] candidates, int target, int start){
        
        if(target == 0){
            ans.add(new ArrayList(list));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = start; i< candidates.length; i++){
            list.add(candidates[i]);
            backtracking(ans,list,candidates,target-candidates[i],i);
            list.remove(list.size()-1);
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtracking(ans,list,candidates,target,0);
        
        return ans;
    }
}