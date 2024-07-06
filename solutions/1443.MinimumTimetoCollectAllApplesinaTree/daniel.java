class Solution {

    public int dfs(int curr, int parent, Map<Integer, List<Integer>> edges, List<Boolean> hasApple){
      
        int time = 0;

        for(int child : edges.get(curr)){
            
            if(child == parent){
                continue;
            }
            int totalTime = dfs(child,curr,edges,hasApple);
            
            if(totalTime > 0 || hasApple.get(child)){
                time += 2 + totalTime;
            }
        }

        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();


        for(int i =0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];

            if(map.containsKey(from)){
                List<Integer> edge = map.get(from);
                edge.add(to);
                map.put(from,edge);
            }else{
                List<Integer> edge = new ArrayList<>();
                edge.add(to);
                map.put(from,edge);
            }

            if(map.containsKey(to)){
                List<Integer> edge = map.get(to);
                edge.add(from);
                map.put(to,edge);
            }else{
                List<Integer> edge = new ArrayList<>();
                edge.add(from);
                map.put(to,edge);
            }
        }

        return dfs(0,-1,map,hasApple,visited);
    }
}