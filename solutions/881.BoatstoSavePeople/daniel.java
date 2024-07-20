class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Map<Integer,Integer> map = new TreeMap<>((a,b)-> b.compareTo(a));

        for(int i =0; i < people.length; i++){
            int frequency = map.getOrDefault(people[i], 0);
            map.put(people[i],++frequency);
        }

        int min = 0;
        int remaining = 0;

        while(!map.isEmpty()){

            int numOfPeople = map.keySet().iterator().next();
            int times = map.get(numOfPeople);

            remaining = limit - numOfPeople;
            
            map.put(numOfPeople, --times);

            if(map.get(numOfPeople) == 0){
                map.remove(numOfPeople);
            }
            
            while(remaining != 0){
                
                if(map.containsKey(remaining)){
                    times = map.get(remaining);
                    map.put(remaining, --times);
                    if(map.get(remaining) == 0){
                        map.remove(remaining);
                    }
                    remaining = 0;
                }else{
                    remaining -= 1;   
                }              
            }

            min += 1;

        }

        return min;
    }
}