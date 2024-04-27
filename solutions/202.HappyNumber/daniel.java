class Solution {
    
    public int convert(int n){
        String curr = String.valueOf(n);
        int newValue = 0;

        for(int i =0; i < curr.length(); i++){
            newValue += Math.pow(Character.getNumericValue(curr.charAt(i)),2);
        }

        return newValue;
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(true){

            n = convert(n);

            if(n == 1){
                return true;
            }

            if(!set.contains(n)){
                set.add(n);
            }else{
                return false;
            }
            
        }

    }
}