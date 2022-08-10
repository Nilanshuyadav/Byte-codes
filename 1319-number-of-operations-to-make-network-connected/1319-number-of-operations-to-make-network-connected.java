class Solution {
    boolean[] vis;
    public int makeConnected(int n, int[][] connections) {
        int V = connections.length;
        
        vis = new boolean[n];
        
        if(n-1 > V) return -1;
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i[] : connections){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        int cnt = 0;
        
        for(int i=0;i<n;i++){
            if(vis[i] != true){
                cnt++;
                function(adj,i);
            }
        }
        
        return --cnt;
        
    }
    
    public void function(List<List<Integer>> adj, int ind){
        vis[ind] = true;
        
        for(int i : adj.get(ind)){
            if(vis[i] != false) continue;
            function(adj,i);
        }
    }
}