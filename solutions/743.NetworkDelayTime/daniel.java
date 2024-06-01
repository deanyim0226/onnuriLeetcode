class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int travelTime = 0;

        Map<Integer, List<Pair<Integer,Integer>>> map = new HashMap<>();
        
        for(int i =0; i < times.length; i++){
            map.put(i+1, new ArrayList<>());
        }

        for(int i =0; i < times.length; i++){
            int sourceNode = times[i][0];
            int targetNode = times[i][1];
            int weight = times[i][2];

            if(map.containsKey(sourceNode)){
                List<Pair<Integer,Integer>> neighbors = map.get(sourceNode);
                neighbors.add(new Pair<>(targetNode,weight));
            }
        }

        PriorityQueue<Pair<Integer,Integer>> pQueue = new PriorityQueue<>((a,b)-> a.getValue() - b.getValue());
        pQueue.add(new Pair<>(k,0));
        Set<Integer> visited = new HashSet<>();

        while(!pQueue.isEmpty()){
            Pair<Integer,Integer> currNode = pQueue.poll();
            int currVtx = currNode.getKey();
            int weight = currNode.getValue();

            if(visited.contains(currVtx)){
                continue;
            }

            travelTime = Math.max(travelTime,weight);
            visited.add(currVtx);
            List<Pair<Integer,Integer>> neighbors = map.get(currVtx);
            if(neighbors != null){
                for(Pair<Integer,Integer> neighbor : neighbors){
                    int targetNode = neighbor.getKey();
                    int targetWeight = neighbor.getValue();

                    if(!visited.contains(targetNode)){
                        pQueue.add(new Pair<>(targetNode, weight+targetWeight));
                    }
                }
            }
       
        }

        return visited.size() == n ? travelTime : -1; 
    }
}