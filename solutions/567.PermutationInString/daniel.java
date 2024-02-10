class Solution {

    public HashMap<Character,Integer> checkPermutation(String s){
        
        HashMap<Character,Integer> map = new HashMap<>();   
        
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            map.put(currChar, map.containsKey(currChar) ? (map.get(currChar)+1) : 1);
        }
        
        return map;
    }
    public boolean checkInclusion(String s1, String s2) {
       
        HashMap<Character,Integer> map = new HashMap<>();   

        int lengthOfS1 = s1.length();

        for(int i =0; i< lengthOfS1; i++){
        
            char currChar = s1.charAt(i);
            map.put(currChar, map.containsKey(currChar) ? (map.get(currChar)+1) : 1);
        }

    
        for(int i = 0; i <= s2.length()-lengthOfS1; i++){
            
            String subString = s2.substring(i, lengthOfS1 + i);

            HashMap<Character,Integer> ans = checkPermutation(subString);

            if(map.equals(ans)){
                return true;
            }
        }

        return false;
    }
}

