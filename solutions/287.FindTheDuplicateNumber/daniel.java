class Solution {
    public int findDuplicate(int[] nums) {
        int repeat = 0;

        for(int i =0; i<nums.length; i++){
            int index = nums[i];
            if(nums[Math.abs(index)] < 0){
                repeat = index;
            }
            nums[Math.abs(index)] = -nums[Math.abs(index)];
        }

        for(int i =0; i<nums.length; i++){
            if(nums[i]< 0){
                nums[i] = -nums[i];
            }
        }



        return Math.abs(repeat);
    }
}