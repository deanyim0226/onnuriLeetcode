class Solution {
    
    public int maxSubArray(int[] nums) {
   
        int maxSub = Integer.MIN_VALUE;
        int currMax = 0;
        for(int i =0; i < nums.length; i++){
            
            currMax = Math.max(nums[i], currMax+nums[i]);
            maxSub = Math.max(currMax,maxSub);
        }

        return maxSub;

    }


}