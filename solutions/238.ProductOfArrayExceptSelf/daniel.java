class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        Initial approcah 

        divide list into left and right based on current index

        1 [2,3,4]
        [1] 2 [3,4]
        [1,2] 3 [4]
        [1,2,3] 4

        o(n^2) time limit exceeded.
      
        int[] ans = new int[nums.length];

        int leftProduct = 1;
        int rightProduct = 1;

        int leftP =0;
        int rightP = 0;

       for(int i = 0; i<nums.length; ++i){

            leftP = 0;
            rightP = nums.length-1;

            while(i < rightP){
                rightProduct *= nums[rightP];
                rightP -=1;
            }

            while(leftP < i){
                leftProduct *= nums[leftP];
                leftP += 1;
            }

            ans[i] = leftProduct*rightProduct;
        
            leftProduct = 1;
            rightProduct = 1;
        }

        return ans;
        */

        /*
        solve this problem in o(n) to avoid getting a time limit exceed
        a a1 a2 .. an-2 an-1 

        find the product of all the elements on the left side except nums[i] 
        find the product of all the elements on the right side except nums[i]
        and multiply each of the corresponding indexes by each other.

        time complexity of this algorithm is o(n) where n is the number of elements in array
        space complexity is also o(n) since we create two arrays of sizes n 
        where n is the number of elements in array
        1 2 3 4
        1 1 2 6
        24 12 4 1  
        */  
        int[] leftSide = new int[nums.length];
        int[] rightSide = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                leftSide[i] = 1;
            }else if (i == 1){
                leftSide[i] = nums[i-1];
            }else{
                leftSide[i] = leftSide[i-1] * nums[i-1];
            }
        }      

        for(int i = nums.length-1; i >= 0; i--){
            if(i == nums.length-1){
                rightSide[i] = 1;
            }else if(i == nums.length-2){
                rightSide[i] = nums[nums.length-1];
            }else{
                rightSide[i] = rightSide[i+1] * nums[i+1];
            }
        }    

        for(int i = 0; i <nums.length; i++){
            nums[i] = leftSide[i] * rightSide[i];
        }

        return nums;
    }


}