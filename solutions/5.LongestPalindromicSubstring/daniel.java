class Solution {
    public String longestPalindrome(String s) {
        
        String longest = "";
        String curr = "";

        for(int i =0; i < s.length(); i++){

            int left = i;
            int right = i;

            while(left <= right && left >= 0 && right <= s.length()-1){
                if(s.charAt(left) == s.charAt(right)){
                    curr = s.substring(left,right+1);
                    left -= 1;
                    right += 1;
                }else{
                    break;
                }
            }

            if(curr.length() > longest.length()){
                longest = curr;
            }

            left = i;
            right = i+1;

            while(left <= right && left >= 0 && right <= s.length()-1){
                if(s.charAt(left) == s.charAt(right)){
                    curr = s.substring(left,right+1);
                    left -= 1;
                    right += 1;
                }else{
                    break;
                }
            }

            if(curr.length() > longest.length()){
                longest = curr;
            }


        }

        return longest;

    }
}