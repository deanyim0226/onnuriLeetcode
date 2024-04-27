class Solution {

    public boolean isPalindrome(String string){

    }

    public int countSubstrings(String s) {

        int count = 0;

        for(int i = 0; i < s.length(); i++){
            int left = i;
            int right = i;

            while(left > -1 && right < s.length() && left <= right){

                if(s.charAt(left) == s.charAt(right)){
                    count += 1;
                }else{
                    break;
                }
                left -= 1;
                right += 1;
            }

            left = i;
            right = i+1;

            while(left > -1 && right < s.length() && left <= right){

                if(s.charAt(left) == s.charAt(right)){
                    count += 1;
                }else{
                    break;
                }
                left -= 1;
                right += 1;
            }
        }
  
        return count;
    }
}