class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++){
            adj.add(new ArrayList<>());
        }
        
        for(int ind[] : prerequisites){
            adj.get(ind[0]).add(ind[1]);
        }
        
        Boolean[] vis = new Boolean[n];
        
        for(int ind=0; ind<n; ind++){
            if(vis[ind] == null){
                solve(ind, adj, vis);
            }
        }
        
        for(boolean bool : vis){
            if(!bool){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean solve(int ind, List<List<Integer>> adj, Boolean[] vis){
        if(vis[ind]!=null){
            return vis[ind];
        }
        
        vis[ind] = false;
        
        boolean bool = true;
        
        for(int inx : adj.get(ind)){
            bool = bool && solve(inx, adj, vis);    
        }
        
        return vis[ind] = bool;
    }
}