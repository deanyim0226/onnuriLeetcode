class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs,(a,b)-> Integer.compare(a.length(), b.length()));

        String minString = strs[0];

        for(int i =1; i < strs.length; i++){
            
            String subString = strs[i].substring(0,minString.length());
            while(!subString.equals(minString)){
                minString = minString.substring(0,minString.length()-1);
                subString = subString.substring(0,subString.length()-1);
            }
            
        }
    
        /*
        find min length of string
        */

        return minString;
    }
}