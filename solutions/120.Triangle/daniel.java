class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        /*
        [row][col]
        [row][col] [row][col+1]
        [row][col] [row][col+1] [row][col+2]
        */
        for(int row = triangle.size()-2; row >= 0; row--){
            
            for(int col = 0; col <= row; col++){

                int min = Math.min(triangle.get(row+1).get(col), triangle.get(row+1).get(col+1));
                int curr = triangle.get(row).get(col);
                triangle.get(row).set(col, curr+ min);
            }

        }

        return triangle.get(0).get(0);
    }
}