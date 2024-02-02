class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        StringBuilder ans = new StringBuilder("");

        for(int i =0; i < s.length(); i++){
            
            char currChar = s.charAt(i);
            if( Character.isLetter(currChar) || Character.isDigit(currChar)){
                ans.append(currChar);
            }
        }

        int left = 0;
        int right = ans.length()-1;
        
        while(left <= right){

            if(ans.charAt(left) != ans.charAt(right)){
                return false;
            }
            left += 1;
            right -= 1;
        }

    
        return true;
    }
}