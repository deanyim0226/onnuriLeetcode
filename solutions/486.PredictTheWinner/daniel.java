class Solution {
  

    public int recursion(int[] nums, int left, int right, boolean turn){

        if(left > right){
            return 0;
        }

        if(turn){
            int leftPicked = nums[left] + recursion(nums,left+1, right, false);
            int rightPicked = nums[right] + recursion(nums,left,right-1, false);
            return Math.max(leftPicked,rightPicked);
        }else{
            int leftPicked = -nums[left] + recursion(nums,left+1, right, true);
            int rightPicked = -nums[right] + recursion(nums,left,right-1, true);
            return Math.min(leftPicked,rightPicked);
        }


    }
    public boolean predictTheWinner(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int ans = recursion(nums,left,right,true);
       
        if(ans >= 0){
            return true;
        };

        return false;
    }
    
}