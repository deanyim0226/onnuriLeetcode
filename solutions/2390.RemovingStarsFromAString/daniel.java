class Solution {
    public String removeStars(String s) {
        
        StringBuilder ans = new StringBuilder();

        for(int i =0; i < s.length(); i++){
            
            char currChar = s.charAt(i);
            if(currChar == '*'){
                ans.deleteCharAt(ans.length()-1);
            }else{
                ans.append(currChar);
            }
        }
        return ans.toString();
    }
}