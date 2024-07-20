class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<int[]>> edges = new HashMap<>();

        for(int i =0; i < flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];

            if(edges.containsKey(from)){
                List<int[]> list = edges.get(from);
                list.add(new int[] {to,cost});
                edges.put(from,list);
            }else{
                List<int[]> list = new ArrayList<>();
                list.add(new int[] {to,cost});
                edges.put(from,list);
            }
        }

        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        pQueue.add(new int[]{src,0,0});

        while(!pQueue.isEmpty()){
            int[] temp = pQueue.poll();
            int from = temp[0];
            int cost = temp[1];
            int stop = temp[2];

            if(stop > stops[from] || stop > k+1){
                continue;
            }

            stops[from] = stop;
            
            if(from == dst){
                return cost;
            }

            if(edges.containsKey(from)){
                for(int[] temp1 : edges.get(from)){
                    pQueue.add(new int[] {temp1[0], temp1[1]+cost, stop+1});
                }
            }
        }
        return -1;
    }
}