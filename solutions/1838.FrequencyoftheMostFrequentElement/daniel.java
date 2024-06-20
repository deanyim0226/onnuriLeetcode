class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0, right = 0;
        int windowSize = 0;
        long total = 0;

        while(right < nums.length){

            total += nums[right];
            windowSize = right - left + 1;

            if(windowSize * nums[right]  <= k + total){
     
            }else{
                total -= nums[left];
                left += 1;
            }

            right += 1;
        }

        return nums.length-left;
    }
}