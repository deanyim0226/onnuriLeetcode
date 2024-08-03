class Solution {
    public String simplifyPath(String path) {
        
        String[] paths = path.split("/");
        Deque<String> deque = new ArrayDeque<>();

        for(String p : paths){
            
            if(p.equals(".") || p.isEmpty()){
                continue;
            }else if(p.equals("..")){

                if(!deque.isEmpty()){
                    deque.removeLast();
                }
            }else{

                deque.addLast(p);
            }
        }

        StringBuilder newPath = new StringBuilder();
        while(!deque.isEmpty()){
            newPath.append("/");
            newPath.append(deque.removeFirst());
        }
        
        return newPath.isEmpty() ? "/" : newPath.toString();

    }
}