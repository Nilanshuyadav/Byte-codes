class Solution {
    Boolean[] vis;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        vis = new Boolean[n];
        
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j : graph[i])
                adj.get(i).add(j);
        }
        
        for(int i=0;i<n;i++){
            if(function(adj,i))
                ans.add(i);
        }
        
        return ans;
    }
    
    public boolean function(List<List<Integer>> adj, int ind){
        if(vis[ind] != null) return vis[ind];
        vis[ind] = false;
        for(int i : adj.get(ind)){
            if(!function(adj,i))
                return false;
        }
        return vis[ind] = true;
    }
}