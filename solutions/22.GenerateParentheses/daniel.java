class Solution {

    public void backtracking(List<String> ans, String parenthesis, int left,  int right, int n){

        //base case
        if(parenthesis.length() == 2*n){
            ans.add(parenthesis);
        }
        
        if(left < n){
            parenthesis += "(";
            backtracking(ans,parenthesis,left +1, right, n);
            parenthesis = parenthesis.substring(0,parenthesis.length()-1);
        } 
        
        if(right < left){
            parenthesis += ")";
            backtracking(ans,parenthesis,left,right+1, n);
            parenthesis = parenthesis.substring(0,parenthesis.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        backtracking(ans, "", 0, 0, n);

        return ans;

    }
}