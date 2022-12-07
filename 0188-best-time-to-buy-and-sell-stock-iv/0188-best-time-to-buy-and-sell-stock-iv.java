class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        
        for(int ind[][] : dp)
            for(int inx[] : ind)
                Arrays.fill(inx, -1);
        
        return dfs(0, 1, prices, n, k, dp);
    }
    
    public int dfs(int ind, int buy, int[] prices, int n, int k, int[][][] dp){
        if(k<=-1 || ind==n)
            return 0;
        
        if(dp[ind][buy][k] != -1)
            return dp[ind][buy][k];
        
        int price;
        
        if(buy == 1){
            price = Math.max(dfs(ind+1, 0, prices, n, k-1, dp) - prices[ind], dfs(ind+1, 1, prices, n, k, dp));
        }
        else{
            price = Math.max(dfs(ind+1, 1, prices, n, k, dp) + prices[ind], dfs(ind+1, 0, prices, n, k, dp));
        }
        
        return dp[ind][buy][k] = price;
    }
}