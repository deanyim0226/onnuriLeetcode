class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length; 

        int left = row-1;
        int right = 0; 
        //think about this 2d array as 1d array
  
        /*
        starting from bottom leftmost, we observe that 
        if the value is greater than we increase right pointer by 1
        less than decrease left pointer by 1 
        left pointer indicates row right pointer indicates col 
        */
        while(right < col && left >= 0){
            int val = matrix[left][right];
            if(val == target){
                return true;
            }else if(val < target){
                right += 1;
            }else{
                left -= 1;
            }
        }
        
         return false;
    }
}