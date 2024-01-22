class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        /*
        each row increases by 1
        we can simply assume that first index and last index of array 
        are always 1 
        */

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for(int i =0; i< numRows; i++){
            
            row = new ArrayList<>();

            for(int j = 0; j <= i; j++){

                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    int left = ans.get(i-1).get(j-1); 
                    int right = ans.get(i-1).get(j);
                    row.add(left+right);
                }
            }

            ans.add(row);
        }


        return ans;
          
        

    }
}