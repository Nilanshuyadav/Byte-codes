class Solution {
    boolean[] vis;
    public int makeConnected(int n, int[][] connections) {
        int wire = connections.length;
        if(wire<n-1) return -1;
        
        List<List<Integer>> adj = new ArrayList<>();
        vis = new boolean[n];
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<wire;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }    
        
       
        int cnt = 0;
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                function(adj,i);
            }
        }
        return cnt-1;
    }
    
    public void function(List<List<Integer>> adj, int ind){
        vis[ind] = true;
        for(int i : adj.get(ind))
            if(!vis[i])
                function(adj,i);
    }
}