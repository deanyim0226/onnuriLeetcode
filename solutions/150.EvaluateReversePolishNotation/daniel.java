class Solution {
    public int evalRPN(String[] tokens) {
        //postfix notation 

        Stack<Integer> stack = new Stack<>();
        HashMap<Character,Boolean> map = new HashMap<>();
        map.put('+',true);
        map.put('-',true);
        map.put('*',true);
        map.put('/',true);

        int firstNum = 0;
        int secondNum = 0;
        int calculation = 0;

        for(String string : tokens){
            
            if(string.length() == 1){
                char currChar = string.charAt(0);

                if(map.containsKey(currChar)){
                
                    secondNum = stack.pop();
                    firstNum = stack.pop();

                    switch (currChar){

                        case '+':
                            calculation = firstNum + secondNum;
                            break;
                        case '-':
                            calculation = firstNum - secondNum;
                            break;
                        case '*':
                            calculation = firstNum * secondNum;
                            break;
                        case '/':
                            calculation = firstNum / secondNum;
                            break;
                    }

                    stack.push(calculation);
            
                }else{
                    stack.push(Character.getNumericValue(currChar));
                }
            }else{
                stack.push(Integer.parseInt(string));
            }
        
        }
            
        return stack.pop();
    }

     
}
