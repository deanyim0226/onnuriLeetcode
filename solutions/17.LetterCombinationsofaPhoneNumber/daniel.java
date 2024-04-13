class Solution {

      public void backtracking(HashMap<Character,String> map, String digits, int index, String curr, List<String> ans){

        if(curr.length() == digits.length()){
            ans.add(curr);
            return;
        }

        String comb = map.get(digits.charAt(index));
 
        for(int i =0; i < comb.length(); i++){
            curr += comb.charAt(i);
            backtracking(map, digits, index+1, curr, ans);
            curr = curr.substring(0,curr.length()-1);
        }
        
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        List<String> ans = new  ArrayList<>();

        if(digits.isEmpty()){
            return ans;
        }

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        backtracking(map,digits,0,"",ans);
    
        return ans;
    }
}