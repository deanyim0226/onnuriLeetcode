class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[nums.length-1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        //divide into two array based on pivot

        int subLeft1 = 0;
        int subRight1 = left;

        while(subLeft1 <= subRight1){
              
            int mid = (subLeft1 + subRight1)/ 2;

            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                subLeft1 = mid + 1;
            }else{
                subRight1 = mid -1;
            }
            
        }

        int subLeft2 = left;
        int subRight2 = nums.length-1;

        while(subLeft2 <= subRight2){
              
            int mid = (subLeft2 + subRight2)/ 2;

            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                subLeft2 = mid + 1;
            }else{
                subRight2 = mid -1;
            }
            
        }

        return -1;
    }
}