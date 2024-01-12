class Solution {
    public boolean isAnagram(String s, String t) {

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