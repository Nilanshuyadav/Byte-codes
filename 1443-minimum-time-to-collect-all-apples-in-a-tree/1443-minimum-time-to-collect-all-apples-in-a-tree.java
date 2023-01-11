class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++)
            adj.add(new ArrayList<>());
        
        for(int ind[] : edges){
            adj.get(ind[0]).add(ind[1]);
            adj.get(ind[1]).add(ind[0]);
        }
        
        int ans = solve(0, adj, hasApple, -1);
        
        return ans==0?0:ans-2;
    }
    
    public int solve(int ind, List<List<Integer>> adj, List<Boolean> hasApple, int parent){
        int sum = 0;
        
        for(int inx : adj.get(ind)){
            if(inx == parent)
                continue;
            sum += solve(inx, adj, hasApple, ind);
        }
        
        if(sum>0 || hasApple.get(ind))
            return sum + 2;
        
        return sum;
    }
}