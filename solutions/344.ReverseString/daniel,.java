class Solution {
    
    public void recursion(char[] s, int left, int right){

        /*
        base case 
        when right <= left
        return s[right]

        recursion(left+1, right-1)
        0   5       0   4
        1   4       1   3
        2   3       2   2
        3   2
        */

        if(right <= left){

        }else{
            recursion(s,left+1,right-1);
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public void reverseString(char[] s) {
        
        //recursion
        recursion(s,0,s.length-1);
        
        //iteration  
        int left = 0;
        int right = s.length-1;

        while(left <= right){
            
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left += 1;
            right -= 1; 
        }
        
    }
}