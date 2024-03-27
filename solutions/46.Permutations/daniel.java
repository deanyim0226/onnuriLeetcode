class Solution {
    

    public void backtracking(int[] nums, List<Integer> list, List<List<Integer>> ans){

        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i < nums.length; i++){

            if(!list.contains(nums[i])){
                list.add(nums[i]);
                backtracking(nums,list,ans);
                list.remove(list.size()-1);
            }
        }
    } 

    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();

        backtracking(nums,permutation,ans);
        return ans;
    /*
    1           2               3
    1 2         2 1             3 1
    1 2 3       2 1 3           3 1 2
    1 3 2       2 3 1           3 2 1
    */
    }
}