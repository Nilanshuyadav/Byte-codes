class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;
        
        return dfs(n,dp);
    }
    
    public int dfs(int n,int[] dp){
        if(dp[n] != -1) return dp[n];
        
        int sum = 0;
        for(int ind =1;ind<=n;ind++)
            sum += dfs(ind-1,dp)*dfs(n-ind,dp);
        
        return dp[n] = sum;
    }
}