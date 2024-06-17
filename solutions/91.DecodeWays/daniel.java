class Solution {
    Map<Integer,Integer> map = new HashMap<>();

    public int numDecodings(String s) {

        return recursion(s, 0);
    }

    public int recursion(String s, int index){
        
        if(map.containsKey(index)){
            return map.get(index);
        }

        if(index == s.length()){
            return 1;
        }

        if(s.charAt(index) == '0'){
            return 0;
        }

        if(index == s.length()-1){
            return 1;
        }
        
        int ans = recursion(s, index+1);
        if(Integer.parseInt(s.substring(index,index+2)) <= 26){
            ans +=  recursion(s, index+2);
        }

        map.put(index, ans);
        return ans;
    }
}