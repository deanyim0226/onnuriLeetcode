class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxVal = 0;

        for(int pile : piles){
            maxVal = Math.max(maxVal,pile);
        }

        int eatingSpeed = 1;
        int hours = 0;
        int left = 1;
        int right = maxVal;
        
        while(left < right){
            hours = 0;
            eatingSpeed = (left + right )/2;

            for(int pile : piles){
                hours += (int)Math.ceil((double)pile / eatingSpeed);
            }
       
            if(hours <= h){
                right = eatingSpeed;
            }else if(hours > h){
                left = eatingSpeed+1;
            }
            
        }

        return right;
    }
}