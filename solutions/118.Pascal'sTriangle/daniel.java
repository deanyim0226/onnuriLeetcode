class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        /*
        each row increases by 1
        we can simply assume that first index and last index of array 
        are always 1 

        time complexity is o(numRows ^2)
        */

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for(int i =0; i< numRows; i++){
            
            row = new ArrayList<>();

            /*
            0 1 2 3 .. numRows 
            0 + 1 + 2 + ... numRows
            */
            for(int j = 0; j <= i; j++){

                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    int left = ans.get(i-1).get(j-1); 
                    int right = ans.get(i-1).get(j);
                    /*
                    think of this each level as row

                    we can fill the unknown value by adding
                    two numbers in the previous row 
                    index of two numbers are j-1, j 
                    */
                    row.add(left+right);
                }
            }

            ans.add(row);
        }


        return ans;
          
        

    }
}