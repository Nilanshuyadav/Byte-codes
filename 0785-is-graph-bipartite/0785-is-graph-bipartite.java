class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Boolean[] vis = new Boolean[n];
        boolean ans = true;
        
        for(int ind=0; ind<n; ind++){
            if(vis[ind] == null){
                vis[ind] = true;
                ans = ans && checkBipartite(ind, graph, vis);
            }
        }
        
        return ans;
    }
    
    public boolean checkBipartite(int ind, int[][] graph, Boolean[] vis){
        
        boolean ans = true;
        
        for(int inx : graph[ind]){
            if(vis[inx] != null){
                if(vis[inx] == vis[ind])
                    return false;
            }
            else{
                vis[inx] = !vis[ind];
                ans = ans && checkBipartite(inx, graph, vis);
            }
        }
        
        return ans;
    }
}