class Solution {
    public int lengthOfLongestSubstring(String s) {
     
        if(s.length() == 0){
            return 0;
        }

      
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength = 1;
        int leftPos = 0;

        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
          
            if(map.containsKey(currChar)){
         
                leftPos = Math.max(leftPos, map.get(currChar));
                       
            }
            maxLength = Math.max(i - leftPos +1, maxLength); 
            map.put(currChar, i+1);
        }
        
        return maxLength;
    }
}