class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer,Integer> baskets = new HashMap<>();
        
        int right = 0;
        int left = 0;
        int maxNumOfFruits = 0;

        while(right < fruits.length){
            
            int currentFruit = fruits[right];
            
            baskets.put(currentFruit, baskets.getOrDefault(currentFruit,0)+1 );

            while(baskets.size() > 2){
                maxNumOfFruits = Math.max(maxNumOfFruits, right-left);
                int frequency = baskets.get(fruits[left]);
                baskets.put(fruits[left], --frequency);

                if(frequency == 0){
                    baskets.remove(fruits[left]);
                }
                
                left += 1;
            }
           
            right += 1;

        }
        return Math.max(maxNumOfFruits, right-left);

        /*
        int start =0;
        Set<Integer> baskets = new HashSet<>();
        int maxNumOfFruits = 0;

        while(start < fruits.length){
            
            int count = 0;
            for(int i = start; i < fruits.length; i++){
                
                if(baskets.size() <= 1){

                    baskets.add(fruits[i]);
                    count += 1;
                }else{

                    if(baskets.contains(fruits[i])){
                        baskets.add(fruits[i]);
                        count += 1;
                    }else{
                        baskets = new HashSet<>();
                        break;
                    }
                }
            }
            maxNumOfFruits = Math.max(maxNumOfFruits, count);
            start += 1;
        }

        return maxNumOfFruits;

        */
    }
}