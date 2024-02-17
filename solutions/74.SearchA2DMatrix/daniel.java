class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length; 

        int left = row-1;
        int right = 0; 
        //think about this 2d array as 1d array
  
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