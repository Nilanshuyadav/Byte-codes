class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        
        int[][] dp = new int[n][2];
        
        for(int ind[] : dp)
            Arrays.fill(ind, -1);
        
        return dfs(0, prices, n, 1, dp, fee);
    }
    
    public int dfs(int ind, int[] price, int n, int buy, int[][] dp, int fee){
        if(n <= ind)
            return 0;
        
        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        
        int profit;
        
        if(buy == 1){
            profit = Math.max(dfs(ind+1, price, n, 0, dp, fee) - price[ind] - fee, dfs(ind+1, price, n, 1, dp, fee));
        }
        else{
            profit = Math.max(dfs(ind+1, price, n, 1, dp, fee) + price[ind], dfs(ind+1, price, n, 0, dp, fee));
        }
        
        return dp[ind][buy] = profit;
    }
}