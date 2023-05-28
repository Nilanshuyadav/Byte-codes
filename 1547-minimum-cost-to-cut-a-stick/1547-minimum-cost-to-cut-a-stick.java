class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        
        List<Integer> cut = new ArrayList<>();
        cut.add(0);
        for(int ind : cuts){
            cut.add(ind);
        }
        cut.add(n);
        
        int[][] dp = new int[102][102];
        
        for(int ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        return solve(1, cut.size()-2, cut, dp);
    }
    
    public int solve(int s, int e, List<Integer> cut, int[][] dp){
        if(s>e){
            return 0;
        }
        
        if(dp[s][e] != -1)
            return dp[s][e];
        
        int min = (int)1e8;
        for(int ind=s; ind<=e; ind++){
            min = Math.min(min, solve(ind+1, e, cut, dp) + solve(s, ind-1, cut, dp));
        }
        
        dp[s][e] = min+(cut.get(e+1) - cut.get(s-1));
        
        return min + (cut.get(e+1) - cut.get(s-1));
    }
}