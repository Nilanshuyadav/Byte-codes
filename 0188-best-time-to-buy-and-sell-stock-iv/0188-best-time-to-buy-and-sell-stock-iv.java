class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        int[][][] dp = new int[n][2][k];
        
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j, -1);
            }
        }
        
        return solve(0, n, prices, 1, k-1, dp);
    }
    
    public int solve(int ind, int n, int[] prices, int buy, int k, int[][][] dp){
        if(ind == n || k == -1){
            return 0;
        }
        
        if(dp[ind][buy][k] != -1){
            return dp[ind][buy][k];
        }
        
        if(buy == 1 && k>-1){
            return dp[ind][buy][k] = Math.max(solve(ind+1, n, prices, 0, k, dp) - prices[ind], solve(ind+1, n, prices, 1, k, dp));
        }
        else{
            return dp[ind][buy][k] = Math.max(solve(ind+1, n, prices, 1, k-1, dp) + prices[ind], solve(ind+1, n, prices, 0, k, dp));
        }
    }
}