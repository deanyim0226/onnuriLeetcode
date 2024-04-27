class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        
        double[] distanceList = new double[points.length];

        for(int i =0; i < points.length; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];

            double distance = Math.sqrt(Math.pow(x1,2) + Math.pow(y1,2));
            distanceList[i] = distance;
        }

        Arrays.sort(distanceList);
        double boundary = distanceList[k-1];

        int[][] ans = new int[k][2];
        int index = 0;

        for(int i =0; i < points.length; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];

            double distance = Math.sqrt(Math.pow(x1,2) + Math.pow(y1,2));
            
            if(distance <= boundary){
                ans[index][0] = x1;
                ans[index][1] = y1;
                index+=1;
            }
        }

  
        return ans;
    }
}