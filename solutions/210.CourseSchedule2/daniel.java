class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        Topological ordering 
        in order to take a certain course, there are prerequisites to take
        think about each element of array as a vertex and an edge to contect the vertex
        each vertex might have incoming edges or outgoing edges
        if there is a vertex that has no incoming edges, then that vertex is the starting vertex.
        In this case, course that you can take without taking prerequisites

        First I want to the number of incoming edges for each vertex,
        Second I want to know outgoing edges towards each vertex,
        Lastly, I want to use queue to traverse vertices, since I want to traverse level by level
        while traverse vertices, I am going to record it in the array for the order to take the course   
        */

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i < prerequisites.length; i++){
            int preCourse = prerequisites[i][1];
            int course = prerequisites[i][0];
            inDegree[course]++;

            if(map.containsKey(preCourse)){
                List<Integer> courses = map.get(preCourse);
                courses.add(course);
                map.put(preCourse,courses);
            }else{
                List<Integer> courses = new ArrayList<>();
                courses.add(course);
                map.put(preCourse,courses);
            }
        }

        for(int i =0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            
            int vertex = queue.poll();
            ans.add(vertex);
            numCourses--;
            List<Integer> neighbors = map.get(vertex);
            if(neighbors != null){
                for(Integer neighbor : neighbors){
                    inDegree[neighbor]--;

                    if(inDegree[neighbor] == 0){
                        queue.add(neighbor);
                    }
                }
            }
        }
 
        return numCourses != 0 ? new int[0] : ans.stream().mapToInt(Integer::intValue).toArray();
    }
}