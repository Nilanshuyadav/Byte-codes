class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[][][] dp = new int[n][2][2];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j, -1);
            }
        }
        
        return solve(0, prices, n, 1, 1, dp);
    }
    
    public int solve(int ind, int[] prices, int n, int k, int buy, int[][][] dp){
        if(ind == n || k == -1){
            return 0;
        }
        
        if(dp[ind][buy][k] != -1){
            return dp[ind][buy][k];
        }
        
        if(buy == 1 && k>=0){
            return dp[ind][buy][k] = Math.max(solve(ind+1, prices, n, k, 0, dp) - prices[ind], solve(ind+1, prices, n, k, 1, dp));
        }
        else{
            return dp[ind][buy][k] = Math.max(solve(ind+1, prices, n, k-1, 1, dp) + prices[ind], solve(ind+1, prices, n, k, 0, dp));
        }
    }
}