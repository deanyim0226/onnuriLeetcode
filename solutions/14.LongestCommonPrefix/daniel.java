class Solution {
    public String longestCommonPrefix(String[] strs) {
        


        Arrays.sort(strs,(a,b)-> Integer.compare(a.length(), b.length()));
        //sorting o(nlogn)
        /*
        we find the longest prefix
        we can start by min length of string

        iterate string array and 
        extract the prefix string using substring with the size of min string   

        we do this until it matched with minString 

        time complexity o(n * m) where n is the length of string array
        and m is the min length of string 

        space complexity is o(1)
        */
        //
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