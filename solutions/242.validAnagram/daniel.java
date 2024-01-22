class Solution {
    public boolean isAnagram(String s, String t) {
        
        /*
        a word is an anagram if the word can be formed by rearranging the letters of the different word
        which means two words have to be the same length and contain eactly the same letters.

        time complexity of this algorithm is o(n+m) where n is the length of s, m is the length of t 
        asuuming that two strings are the same length, it will be o(n) since o(2n) is also considered o(n)
        
        space complexity of this algorith is o(n+m) where n is a number of unique character and m as well.
        */
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i=0; i < s.length(); ++i){

            if(map.containsKey(s.charAt(i))){
                int currentVal = map.get(s.charAt(i));
                map.put(s.charAt(i), currentVal+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }

        for(int i =0; i< t.length(); ++i){
            if(map.containsKey(t.charAt(i))){
                int currentVal = map.get(t.charAt(i));
                map.put(t.charAt(i),currentVal-1);
            }else{
                map.put(t.charAt(i),1);
            }
        }

        for(Character key : map.keySet()){
            if(map.get(key) > 0){
                return false;
            }
        }

        return true;
    }
}