class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        
        int n = graph.length;
        
        for(int ind=0; ind<n; ind++)
            adj.add(new ArrayList<>());
        
        for(int ind=0; ind<n; ind++){
            for(int inx : graph[ind])
                adj.get(ind).add(inx);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> path = new ArrayList<>();
        path.add(0);
        
        solve(0, n, path, adj, ans);
        
        return ans;
    }
    
    public void solve(int ind, int n, List<Integer> path, List<List<Integer>> adj, List<List<Integer>> ans){
        if(ind == n-1){
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for(int inx : adj.get(ind)){
            path.add(inx);
            
            solve(inx, n, path, adj, ans);
            path.remove(path.size()-1);
        }
    }
}