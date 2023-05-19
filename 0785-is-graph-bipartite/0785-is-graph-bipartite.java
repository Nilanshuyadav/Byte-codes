class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean ans = true;
        int[] color = new int[n];
        
        for(int ind=0; ind<n; ind++){
            if(!vis[ind]){
                color[ind] = 1;
                vis[ind] = true;
                ans = ans && checkBipartite(ind, graph, vis, color);
            }
        }
        
        return ans;
    }
    
    public boolean checkBipartite(int ind, int[][] graph, boolean[] vis, int[] color){
        
        boolean ans = true;
        
        for(int inx : graph[ind]){
            if(vis[inx]){
                if(color[inx] == color[ind])
                    return false;
            }
            else{
                vis[inx] = true;
                color[inx] = (color[ind]+1)%2;
                ans = ans && checkBipartite(inx, graph, vis, color);
            }
        }
        
        return ans;
    }
}