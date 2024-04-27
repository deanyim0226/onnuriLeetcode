class Solution {
    
    public int rob(int[] nums) {
        /*
        two lists 
        nums[0 -> n-2] 
        nums[1 -> n-1] 
        */ 
        int[] option1 = new int[nums.length-1];
        int[] option2 = new int[nums.length-1];
        for(int i =0; i< nums.length-1; i++){
            option1[i] = nums[i];
        }
        for(int i =1; i< nums.length; i++){
            option2[i-1] = nums[i];
        }

        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return nums[0] < nums[1] ? nums[1] : nums[0];
        }


        int[] dp1 = new int[nums.length-1];
        dp1[0] = option1[0];
        dp1[1] = Math.max(option1[0],option1[1]);

        for(int i = 2; i < option1.length; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + option1[i]);
        }


        int[] dp2 = new int[nums.length-1];
        dp2[0] = option2[0];
        dp2[1] = Math.max(option2[0],option2[1]);

        for(int i = 2; i < option2.length; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + option2[i]);
        }

        return Math.max(dp1[dp1.length-1], dp2[dp2.length-1]);
    }
}