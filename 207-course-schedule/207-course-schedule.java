class Solution {
    boolean[] visited, dfs;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses]; dfs = new boolean[numCourses];
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i[] : prerequisites)
            adj.get(i[0]).add(i[1]);
        
        for(int i = 0; i<numCourses;i++){
            if(visited[i] == false){
                if(checkCycle(i,adj)) return false;
            }
        }
        
        return true;
    }
    
    public boolean checkCycle(int ind,List<List<Integer>> adj){
                
        visited[ind] = true;
        dfs[ind] = true;
        
        for(int i : adj.get(ind)){
            if(visited[i] == true && dfs[i] == true) return true;
            else if(visited[i] == true) continue;
            else if(checkCycle(i,adj)) return true;
        }
        
        dfs[ind] = false;
        
        return false;
    }
}