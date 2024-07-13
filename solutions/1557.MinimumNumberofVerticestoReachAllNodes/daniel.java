class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        /*
        find the indices that have no incoming edges 
        */

        int[] indegree = new int[n];

        for(int i =0; i < edges.size(); i++){

            int from = edges.get(i).get(0);
            int to = edges.get(i).get(1);

            indegree[to]+= 1;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i =0; i< indegree.length; i++){
            
            if(indegree[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }
}