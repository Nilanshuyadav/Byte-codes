class Solution {
    boolean[] vis;
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        vis = new boolean[n];
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i[] : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        long sum = 0;
        long cnt = 0;
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt = function(adj,i);
                sum += cnt*(n-cnt);
            }    
        }
        return sum/2;
    }
    
    public long function(List<List<Integer>> adj, int ind){
        vis[ind] = true;
        long sum = 1;
        for(int i : adj.get(ind)){
            if(!vis[i]) sum += function(adj,i);
        }
        return sum;
    } 
}