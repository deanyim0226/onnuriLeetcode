class Solution {
    public int minCostConnectPoints(int[][] points) {
     
        Map<Integer,List<Pair<Integer,Integer>>> map = new HashMap<>();

        for(int i =0; i< points.length; i++){
            map.put(i,new ArrayList<>());
        }

        for(int i=0; i< points.length; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i+1; j < points.length; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int distance = Math.abs(x1-x2) + Math.abs(y1-y2);

                if(map.containsKey(i)){
                    List<Pair<Integer,Integer>> neighbors = map.get(i);
                    neighbors.add(new Pair(distance,j));
                }

                if(map.containsKey(j)){
                    List<Pair<Integer,Integer>> neighbors = map.get(j);
                    neighbors.add(new Pair(distance,i));
                }

            }
        }

        PriorityQueue<Pair<Integer,Integer>> pQueue = new PriorityQueue<>((a,b)-> a.getKey() - b.getKey());
        Set<Integer> visited = new HashSet<>();
        pQueue.add(new Pair<>(0,0));
   
        int weight = 0;
        while(visited.size() < points.length){

            Pair<Integer,Integer> currVtx = pQueue.poll();
     
            int vertex = currVtx.getValue();
            int distance = currVtx.getKey();

            if(visited.contains(vertex)){
                continue;
            }

            weight += distance;
            visited.add(vertex);

            List<Pair<Integer,Integer>> neighbors = map.get(vertex);
            for(Pair<Integer,Integer> neighbor : neighbors){
                pQueue.add(neighbor);
            }
        }

        return weight;
    }
}