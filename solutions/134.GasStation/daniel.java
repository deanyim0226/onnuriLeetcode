class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()){
            return -1;
        }

        int currGas = 0;
        int startIdx = 0;

        for(int i =0; i < gas.length; i++){

            currGas += gas[i] - cost[i];

            if(currGas < 0){
                currGas = 0;
                startIdx = i+ 1;
            }
        }

        return startIdx;
    }
}