class Solution {
    boolean vis[];
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        vis= new boolean[n+1];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(isConnected[i][j] == 1)
                    adj.get(i+1).add(j+1);
            }
        }
        
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                vis[i] = true;
                ans++;
                function(adj,i);
            }
        }    
        
        return ans;
    }
    
    public void function(List<List<Integer>> adj, int ind){
        for(int i : adj.get(ind))
            if(!vis[i]){
                vis[i] = true;
                function(adj,i);
            }
    }
}