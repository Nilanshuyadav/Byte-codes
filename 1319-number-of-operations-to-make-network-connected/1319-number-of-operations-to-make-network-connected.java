class Solution {
    public int makeConnected(int n, int[][] connections) {
        int wire = connections.length;
        
        if(wire < n-1) return -1;
        
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i[] : connections){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        int ans = -1;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans++;
                vis[i] = true;
                q.add(i);
                while(!q.isEmpty()){
                    int temp = q.remove();
                    for(int ind : adj.get(temp))
                        if(!vis[ind]){
                            vis[ind] = true;
                            q.add(ind);
                        }
                }
            }
        }
        return ans;
    }
}