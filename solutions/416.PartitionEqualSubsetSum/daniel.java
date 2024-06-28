class Solution {
    
    public boolean bfs(int[] nums, int target, int sum, int index, Boolean[][] memo){
        if(sum == target){
            return true;
        } 

        else if(index == nums.length || sum > target){
            return false;
        } 

        else if(memo[index][sum] != null){
            return memo[index][sum];
        } 
      
        boolean result = bfs(nums, target, sum+nums[index], index+1 , memo) || bfs(nums, target, sum, index+1, memo);
        memo[index][sum] = result;

        return result;
        
    }
    public boolean canPartition(int[] nums) {
        
        int sum = Arrays.stream(nums).sum();
        
        if(sum % 2 != 0){
            return false;
        }

        Boolean[][] memo = new Boolean[nums.length+1][sum+1];

        return bfs(nums,sum/2,0,0,memo);
    }
}