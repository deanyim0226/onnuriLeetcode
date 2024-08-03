class Solution {
    public String minRemoveToMakeValid(String s) {
        /*
        return string
        stack to keep index of the parentheses 
        basically whenever encounter close parentheses pop the element
        */

        StringBuilder returnString = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indexToRemove = new HashSet<>();

        for(int i =0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar != ')' && currChar != '(' ){

            }else{

                if(currChar == '('){
                    stack.push(i);
  
                }else{
                    if(!stack.isEmpty()){
                        stack.pop();
                    }else{

                        indexToRemove.add(i);
                    }
             
                }
            }
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            indexToRemove.add(index);
        }

        for(int i =0; i < s.length(); i++){

            if(!indexToRemove.contains(i)){
                returnString.append(s.charAt(i));
            }
        }

        return returnString.toString();
        
    }
}