class Solution {
    boolean[] vis;
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<=V;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<V;i++){
            for(int j =0;j<V;j++){
                if(i == j) continue;
                if(isConnected[i][j] == 1)
                    adj.get(i+1).add(j+1);
            }
        }
        
        vis = new boolean[V+1];
        int cnt= 0;
        
        for(int i=1;i<=V;i++){
            if(vis[i] != true){
                cnt++;
                function(adj,i);
            }
        }
        
        return cnt;
    }
    
    public void function(List<List<Integer>> adj, int ind){
        vis[ind] = true;
        
        for(int i : adj.get(ind)){
            if(vis[i] == true) continue;
            function(adj,i);
        }
    }
}