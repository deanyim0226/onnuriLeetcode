class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        int leftHeight = height[left];
        int rightHeight = height[right];

        while(left < right){
            
            if(leftHeight < rightHeight){
                
                int currArea = leftHeight * (right-left);
                maxArea = Math.max(maxArea,currArea);
                left += 1;
                leftHeight = height[left];
            }else{
                int currArea = rightHeight * (right-left);
                maxArea = Math.max(maxArea,currArea);
                right -= 1;
                rightHeight = height[right];
            }
        }

        return maxArea;
    }
}