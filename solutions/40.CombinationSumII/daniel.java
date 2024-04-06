class Solution {
    
      public void backtracking( List<List<Integer>> ans, List<Integer> list, int[] candidates, int target, int index ){

        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = index; i < candidates.length; i++){
            
            if(i == index || candidates[i] != candidates[i-1]){
                list.add(candidates[i]);
                backtracking(ans,list,candidates,target-candidates[i], i+1);
                list.remove(list.size()-1);
            }
 
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backtracking(ans, list,candidates,target,0);

        return ans;
    }
        
}