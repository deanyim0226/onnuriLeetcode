class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     
        Arrays.sort(nums);
  
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>(); 
        List<Integer> list = null;
      //  -4 -2 -1 -1 0 1 2 3
        for(int i =0; i < nums.length; i++){
            int targetVal = nums[i];
            int left = i + 1;
            int right = nums.length-1;

            while(left < right){

                int sum = nums[left] + nums[right] + targetVal;
          
                if(sum == 0){
                    list = new ArrayList<>();
                    list.add(targetVal);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    set.add(list);
                    left += 1;
                }else if(sum > 0){
                    right -= 1;
                }else{
                    left += 1;
                }  
            }
       
        }

        return List.copyOf(set);
    }
}