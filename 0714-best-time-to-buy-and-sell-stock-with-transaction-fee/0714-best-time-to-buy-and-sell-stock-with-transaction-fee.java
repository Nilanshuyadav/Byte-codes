class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length, dp[][] = new int[n][2];
        
        for(int ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        return solve(0, prices, fee, 1, n, dp);
    }
    
    public int solve(int ind, int[] prices, int fee, int buy, int n, int[][] dp){
        if(ind >= n){
            return 0;
        }
        
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        
        int max=0;
        
        if(buy==1){
            max = Math.max(solve(ind+1, prices, fee, 0, n, dp) - prices[ind] - fee, solve(ind+1, prices, fee, 1, n, dp));    
        }
        else{
            max = Math.max(prices[ind] + solve(ind+1, prices, fee, 1, n, dp), solve(ind+1, prices, fee, 0, n, dp));
        }
        
        return dp[ind][buy] = max;
    }
}