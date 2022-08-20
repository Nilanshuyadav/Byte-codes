class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length,cnt = 0;
        
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(isConnected[i][j] == 1)
                adj.get(i+1).add(j+1);
            }
        }
        
        boolean[] vis = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                cnt++;
                q.add(i);
                
                while(!q.isEmpty()){
                    int ind = q.remove();
                    vis[ind] = true;
                    for(int j : adj.get(ind)){
                        if(!vis[j])
                            q.add(j);
                    }
                }
            }
        }
        
        return cnt;
        
    }
}