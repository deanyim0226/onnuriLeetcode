class Solution {
    
    public int coinChange(int[] coins, int amount) {
    
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i =1; i < dp.length; i++){
            dp[i] = amount+1;
        }
  
        for(int i =1; i <= amount; i++){

            for(int coin : coins){
                int remainingCoin = i - coin;

                if(remainingCoin == 0){
                    dp[i] = 1;
                }else if(remainingCoin > 0){
                    dp[i] = Math.min(dp[i], dp[remainingCoin]+1);
                }
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];
        
    }
}