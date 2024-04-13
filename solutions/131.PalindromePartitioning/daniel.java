class Solution {
    public boolean isPalindrome(String test, int left, int right){

        while(left <= right){

            if(test.charAt(left) != test.charAt(right)){
                return false;
            }
            left+=1;
            right -=1;
        }
        return true;
    }
    public void backtracking(List<List<String>> ans, List<String> list, String s, int start){
        if(s.length() <= start){
            ans.add(new ArrayList<>(list));
        }

        for(int i= start; i < s.length(); i++){

            if(isPalindrome(s,start,i)){
                list.add(s.substring(start,i+1));
                backtracking(ans,list,s,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        backtracking(ans,list,s,0);

        return ans;
    }
}