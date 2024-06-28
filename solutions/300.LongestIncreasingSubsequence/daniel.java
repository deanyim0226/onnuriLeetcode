class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];

        for(int i =0; i < dp.length; i++){
            dp[i] = 1;
        }

        for(int i = 1; i< dp.length; i++){

            for(int start = 0; start < i; start++){
                
                if(nums[i] > nums[start]){
                    dp[i] = Math.max(dp[i], dp[start]+1);
                }
            }
        }

        return Arrays.stream(dp).max().orElse(-1);
    }
}