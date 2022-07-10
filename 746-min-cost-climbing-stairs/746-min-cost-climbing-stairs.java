class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        
        int a = helper(0,cost,n,dp);
        
        Arrays.fill(dp,-1);
        int b = helper(1,cost,n,dp);
        
        return Math.min(a,b);
    }
    
    public int helper(int ind,int[] cost, int N,int[] dp){
        if(ind >= N)
            return 0;
        
        if(dp[ind] != -1) return dp[ind];
        
        return dp[ind] = cost[ind] + Math.min(helper(ind+1,cost,N,dp),helper(ind+2,cost,N,dp));
    }
}