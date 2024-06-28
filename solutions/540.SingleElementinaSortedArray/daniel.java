class Solution {
    public int singleNonDuplicate(int[] nums) {
        /*

        perform binary search on odd length of array 
        and update lo and hi variables accordingly based on the length
        */

        int lo = 0, hi = nums.length-1;

        while(lo <= hi){

            int mid = (lo + hi) / 2;

            if(mid +1 <= hi && nums[mid] == nums[mid+1]){
                if((hi - mid + 1) % 2 == 1){
                    lo = mid + 2;
                }else{
                    hi = mid - 1;
                }
            }else if(mid-1 >= 0 && nums[mid] == nums[mid-1]){
                if((mid - lo - 1) % 2 == 1){
                    hi = mid - 2;
                }else{
                    lo = mid + 1;
                }
            }else{
                return nums[mid];
            }
        }

        return nums[lo];
    }
}