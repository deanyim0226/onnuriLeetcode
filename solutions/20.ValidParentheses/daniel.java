class Solution {
    public boolean isValid(String s) {
        
        Map<Character,Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
    
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        for(int i =0; i < s.length(); i++){
            char currChar = s.charAt(i);

            if(map.containsKey(currChar)){
                
                if(!stack.isEmpty()){
                    char topChar = stack.pop();

                    if(topChar != map.get(currChar)){
                        return false;
                    }
                }else{
                    return false;
                }
   
            }else{
                stack.push(currChar);
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return true;

    }
}