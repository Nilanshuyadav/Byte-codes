class Solution {
    boolean[] vis;
    List<Integer> ans;
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int V = adj.length;
        vis = new boolean[V];
        ans = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(vis[i] != true)
                function(i,adj);
        }
        Collections.sort(ans);
        return ans;
    }
    
    public boolean function(int ind, int[][] adj){
        boolean bool = true;
        vis[ind] = true;
        
        for(int i : adj[ind]){
            if(vis[i] != false){
                // if(ans.contains(i)) {ans.add(ind); return true;}
                // else return false;
                if(!ans.contains(i)) return false;
            }
            else bool = bool && function(i,adj);
        }
        
        if(bool == true) ans.add(ind);
        return bool;
    }
}