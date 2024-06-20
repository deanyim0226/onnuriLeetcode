class Solution {
    
    public boolean backtracking(int[] nums, int index){

        if(index == nums.length-1){
            return true;
        }
        int farthest = Math.min(index + nums[index], nums.length-1); 
        for(int i = index + 1; i<= farthest; i++){
            if(backtracking(nums,i)){
                return true;
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        
        int goal = nums.length - 1;

        for(int i = goal-1; i >= 0; i--){

            if(nums[i] + i >= goal){
                goal = i;
            }
        }

        return goal == 0 ? true : false; 
    }
}