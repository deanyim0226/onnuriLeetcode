class Solution {
    
    public int recursion(int[] cost, int currCost, int start){
        if(start >= cost.length){
            return currCost;
        }
        return Math.min(recursion(cost,currCost+cost[start], start+1), recursion(cost,currCost+cost[start],start+2));
    }

    public int minCostClimbingStairs(int[] cost) {
   

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i =2; i < cost.length; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[cost.length-1],dp[cost.length-2]);

        //return Math.min(recursion(cost,0,0), recursion(cost,0,1));

    }
}