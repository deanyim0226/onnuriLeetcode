class Solution {
    
    public int recursion(int n){
     
        if(n == 1){
            return 1;
        }else{
            return 2 * recursion(n/2);
        }
    }

    public boolean isPowerOfTwo(int n) {

        if(n <= 0){
            return false;
        }

        if(n == recursion(n)){
            return true;
        }

        return false;
    }
}