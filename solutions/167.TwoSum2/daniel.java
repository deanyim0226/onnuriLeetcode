class Solution {
    public int[] twoSum(int[] numbers, int target) {
  
        int left = 0;
        int right = numbers.length-1;

        int ans[] = new int[2];

        int leftElement = numbers[left];
        int rightElement = numbers[right];
    
        while(left < right){

            int sum = leftElement + rightElement;
            if(sum == target){
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            }else if(sum < target){
                left += 1;
                leftElement = numbers[left];
            }else{
                right -=1;
                rightElement = numbers[right];
            }
            
        }

        return ans;

        /*
        Initial approach
        */

        /*
        int ans[] = new int[2];

        int left = 0;
        int right = 1;

        while(left <= numbers.length-1){
            if(right == numbers.length){
                left += 1;
                right = left+1;
            }
            int sum = numbers[left] + numbers[right];
            if(target == sum){
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            }else{
                right += 1;
            }

        }

        return ans;
        */
    }
}