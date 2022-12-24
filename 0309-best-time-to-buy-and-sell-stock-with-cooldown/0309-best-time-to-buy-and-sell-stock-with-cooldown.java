class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        
        for(int ind[] : dp)
            Arrays.fill(ind, -1);
        
        return dfs(0, prices, n, 1, dp);
    }
    
    public int dfs(int ind, int[] prices, int n, int buy, int[][] dp){
        if(n <= ind)
            return 0;
        
        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        
        int temp = 0;
        
        if(buy == 1){
            temp = Math.max(dfs(ind+1, prices, n, 0, dp) - prices[ind], dfs(ind+1, prices, n, 1, dp));
        }
        else{
            temp = Math.max(dfs(ind+2, prices, n, 1, dp) + prices[ind], dfs(ind+1, prices, n, 0, dp));
        }
        
        return dp[ind][buy] = temp;
    }
}