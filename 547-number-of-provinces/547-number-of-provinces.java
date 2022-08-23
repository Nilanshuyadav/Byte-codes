class Solution {
    public int findCircleNum(int[][] isConnected) {
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        boolean[] vis = new boolean[n+1];
        
        for(int i =0;i<=n;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(isConnected[i][j] == 1) adj.get(i+1).add(j+1);
            }
        }
        
        int cnt = 0;
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                cnt++;
                vis[i] = true;
                q.add(i);
                while(!q.isEmpty()){
                    int temp = q.remove();
                    for(int j : adj.get(temp))
                        if(!vis[j]){
                            vis[j] = true;
                            q.add(j);
                        }
                }
            }
        }
        return cnt;
    }
}