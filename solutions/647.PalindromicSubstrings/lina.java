class Solution {
    public int output = 0;
    public int n = 0;
    public int countSubstrings(String s) {
        
        n = s.length();

        for(int i = 0; i < n; i++)
        {
            helper(i,i,s);
            helper(i,i+1,s);
        }

        return output;
    }
    public void helper(int i, int j, String s)
    {
        while(i > 0 && i < n && j > 0 && j < n && s[i] == s[j])
        {
            output += 1;
            i--;
            j++;
        }
    }
}