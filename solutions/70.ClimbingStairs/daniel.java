class Solution {

    public int recursion(int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return recursion(n-1) + recursion(n-2);
    }

    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;        

        for(int i =3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}