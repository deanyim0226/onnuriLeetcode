class Solution {

    public int recursion(int[] nums, int position){
        if(position >= nums.length){
            return 0;
        }

        return Math.max(recursion(nums,position+1), recursion(nums,position+2) + nums[position]);
    }
    
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return nums[0] < nums[1] ? nums[1] : nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        
        return dp[nums.length-1];
    }
}