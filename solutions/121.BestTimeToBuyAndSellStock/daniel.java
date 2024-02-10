class Solution {
    public int maxProfit(int[] prices) {
        
        int left = 0;
        int right = left +1;
        int maxProfit = 0;

        while(left < prices.length && right < prices.length){
            
            int currProfit = prices[left]- prices[right];

            if(currProfit > 0){
                left += 1;
                right = left + 1;
            }else{
                maxProfit = Math.min(currProfit,maxProfit);
                right += 1;
            }
        }

        return -maxProfit;
   
    }
}