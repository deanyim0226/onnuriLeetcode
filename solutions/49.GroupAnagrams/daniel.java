class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        /*
        if we can find a word that contains the same counts of letters in the words or given input, group them using a list

        iterate the array 
        and group the word that has the same chracters using a map data structure
        if two maps that have same key and value pair are anagrams,  
        then put it in the same bucket
        
        brute force approach

        time complexity of this algorithm is o(n*m) where n is the length of array m is average length of each string
        space complexity of this algorithm is o(n*m)  
        we create a frequency map for each string and store in the map, 
        additionally the grouped strings in list 
        */

        List<List<String>> ans = new ArrayList<>();
        HashMap<HashMap<Character,Integer>, List<String>> map = new HashMap<>();

        for(int i =0; i < strs.length; ++i){
            
            HashMap<Character,Integer> tempMap = new HashMap<>();
            for(int j = 0; j < strs[i].length(); ++j){
                char currentChar = strs[i].charAt(j);
                if(tempMap.containsKey(currentChar)){
                    int frequency = tempMap.get(currentChar);
                    tempMap.put(currentChar, frequency+1);
                }else{
                      tempMap.put(strs[i].charAt(j),1);
                }
            }

            if(map.containsKey(tempMap)){
                List<String> group = map.get(tempMap);
                group.add(strs[i]);
                map.put(tempMap,group);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(tempMap, newList);
            }
           
        }

        for(List<String> value : map.values()){
            ans.add(value);
        }
     
        return ans;
    }   
}