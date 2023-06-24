class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[][] dp = new int[n][2];
        
        for(int ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        return solve(0, n, prices, 1, dp);
    }
    
    public int solve(int ind, int n, int[] prices, int buy, int[][] dp){
        if(ind >= n){
            return 0;
        }
        
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        
        if(buy == 1){
            return dp[ind][buy] = Math.max(solve(ind+1, n, prices, 0, dp) - prices[ind], solve(ind+1, n, prices, 1, dp));
        }
        else{
            return dp[ind][buy] = Math.max(solve(ind+2, n, prices, 1, dp) + prices[ind], solve(ind+1, n, prices, 0, dp));
        }
    }
}