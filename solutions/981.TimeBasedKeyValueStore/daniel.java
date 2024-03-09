class TimeMap {

    private HashMap<String,List<Pair<Integer,String>>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(this.map.containsKey(key)){
            List<Pair<Integer,String>> list = this.map.get(key);
            list.add(new Pair<Integer,String>(timestamp,value));
            this.map.put(key,list);
        }else{
            List<Pair<Integer,String>> list = new ArrayList<>();
            Pair<Integer,String> pair = new Pair<>(timestamp,value);
            list.add(pair);
            this.map.put(key,list);
        }
        
    }
    
    public String get(String key, int timestamp) {
        
        String ans = "";

        if(this.map.containsKey(key)){

            List<Pair<Integer,String>> list = this.map.get(key);
            
            int left = 0;
            int right = list.size()-1;

            while(left<= right){

                int mid = (left+right)/2;
                
                if(list.get(mid).getKey() <= timestamp){
                    ans = list.get(mid).getValue();
                    left = mid + 1;  
                }else{
                    right = mid - 1;
                }
            }

            return ans;
        }

        return ans;
   
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */