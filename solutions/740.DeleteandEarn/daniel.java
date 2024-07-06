class Solution {
    public int deleteAndEarn(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.put(nums[i], value+nums[i]);
            }else{
                map.put(nums[i], nums[i]);
            }
        }

        int max = Arrays.stream(nums).max().orElse(-1);

        if(nums.length == 1){
            return nums[0];
        }
        
        int[] dp = new int[max+1];
        dp[1] = map.getOrDefault(1,0);
    
        for(int i =2; i < dp.length; i++){
            
            if(!map.containsKey(i)){
                map.put(i,0);
            }
            dp[i] = Math.max(dp[i-1], dp[i-2] + map.get(i));
            System.out.println(dp[i]);
        }

      
        return dp[max];
    }
}