class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i[] : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        boolean[] vis = new boolean[n];
        long sum = 0,cnt;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                vis[i] = true;
                q.add(i);
                cnt = 0;
                
                while(!q.isEmpty()){
                    int temp = q.remove();
                    cnt++;
                    for(int j : adj.get(temp)){
                        if(!vis[j]){
                            vis[j] = true;
                            q.add(j);
                        }
                    }
                }
                sum += cnt*(n-cnt);
            }
        }
        return (sum/2);
        
    }
}