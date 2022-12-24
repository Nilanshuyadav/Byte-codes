class Solution {
    public int numTilings(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        
        return (int)dfs(n, dp);
    }
    
    public long dfs(int n, long[] dp){
        if(n==0)
            return 1;
        else if(n<3)
            return n;
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = (2*dfs(n-1, dp) + dfs(n-3, dp))%1000000007;
    }
}