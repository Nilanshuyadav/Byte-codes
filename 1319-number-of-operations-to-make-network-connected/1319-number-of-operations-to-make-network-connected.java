class Solution {
    boolean[] vis;
    public int makeConnected(int n, int[][] connections) {
        int wire = connections.length;
        if(wire < n-1) return -1;
        
        vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i[] : connections){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        int ans = -1;
        for(int i=0;i<n;i++)
            if(!vis[i]){
                ans++;
                function(adj,i);
            }
        
        return ans;
    }
    
    public void function(List<List<Integer>> adj , int ind){
        for(int i : adj.get(ind))
            if(!vis[i]){
                vis[i] = true;
                function(adj,i);
            }
    }
}