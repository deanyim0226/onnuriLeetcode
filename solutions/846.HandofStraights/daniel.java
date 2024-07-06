class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        Map<Integer,Integer> map = new TreeMap<>();

        for(int i =0; i < hand.length; i++){
            
            if(map.containsKey(hand[i])){
                int occurrence = map.get(hand[i]);
                map.put(hand[i], ++occurrence);
            }else{
                map.put(hand[i],1);
            }
        }

        while(!map.isEmpty()){
            int curr = map.keySet().iterator().next();

            for(int i = 0; i < groupSize; i++){
                
                int nextcard = curr + i;

                if(map.containsKey(nextcard)){
                    
                    int occurrence = map.get(nextcard);
                    map.put(nextcard,--occurrence);

                    if(map.get(nextcard) == 0){
                        map.remove(nextcard);

                    }

                }else{
                    return false;
                }
            }
        }

        return map.isEmpty() ? true : false;

    }
}