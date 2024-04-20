class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i =0; i < prerequisites.length; i++){
            int preCourse = prerequisites[i][1];
            int postCourse = prerequisites[i][0];
            inDegree[postCourse]++;

            if(map.containsKey(preCourse)){
                List<Integer> preReq = map.get(preCourse);
                preReq.add(postCourse);
                map.put(preCourse,preReq);
            }else{
                List<Integer> preReq = new ArrayList<>();
                preReq.add(postCourse);
                map.put(preCourse,preReq);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i< inDegree.length; i++){
            if(inDegree[i]== 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            numCourses--;
            int currVertex = queue.poll();
            List<Integer> outDegree = map.get(currVertex);
            
            if(outDegree != null){
                for(Integer vertex : outDegree){
                    inDegree[vertex]--;

                    if(inDegree[vertex] == 0){
                        queue.add(vertex);
                    }
                }
            }
        }

        return numCourses == 0 ? true : false;
    }
}