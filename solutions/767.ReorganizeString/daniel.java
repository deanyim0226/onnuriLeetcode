class Solution {
    public String reorganizeString(String s) {
        
        Map<Character, Integer> map = new HashMap<>();

        for(int i =0; i < s.length(); i++){
            int frequency = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++frequency);
        }

        PriorityQueue<Pair<Character,Integer>> pQueue = new PriorityQueue<>(
            (n1,n2) -> map.get(n2.getKey()) - map.get(n1.getKey())
        );

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            
            pQueue.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        Pair<Character,Integer> prev = null;
        String ans = "";
        while(!pQueue.isEmpty()){

            Pair<Character,Integer> pair = pQueue.poll();

            char curr = pair.getKey();
            int frequency = pair.getValue();
    
            frequency -= 1;
            ans += curr;
       
            if(prev != null){
                pQueue.add(prev);
                prev = null;
            }

            if(frequency != 0){
                map.put(curr,frequency);
                prev = new Pair<>(curr,frequency);
            }

        }

        return ans.length() == s.length() ? ans : "";
    }
}