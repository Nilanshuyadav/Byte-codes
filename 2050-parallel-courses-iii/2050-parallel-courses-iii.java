class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n+1];
        int[] dp = new int[n+1];
        
        Arrays.fill(dp, -1);
        
        for(int ind=0; ind<=n; ind++)
            adj.add(new ArrayList<>());
        
        for(int ind[] : relations){
            indegree[ind[0]]++;
            adj.get(ind[1]).add(ind[0]);
        }
        
        int max = 0;
        
        for(int ind=1; ind<=n; ind++){
            if(indegree[ind] == 0){
                max = Math.max(max,solve(ind, adj, time, dp));
            }
        }
        
        return max;
    }
    
    public int solve(int ind, List<List<Integer>> adj, int[] time, int[] dp){
        int max = 0;
        
        if(dp[ind] != -1)
            return dp[ind];
        
        for(int inx : adj.get(ind))
            max = Math.max(max, solve(inx, adj, time, dp));
        
        return dp[ind] = max+time[ind-1];
    }
}