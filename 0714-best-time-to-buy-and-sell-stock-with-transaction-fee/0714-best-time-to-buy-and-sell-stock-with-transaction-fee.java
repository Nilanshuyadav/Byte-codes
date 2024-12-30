class Solution {
    public int maxProfit(int[] prices, int fee) {
       int n = prices.length;

        int[][] dp = new int[n+1][2];

        for(int[] ind : dp) Arrays.fill(ind, -1);

        return helper(0, n, 0, prices, fee, dp); 
    }

    public int helper(int ind, int n, int isBuy, int[] prices, int fee, int[][] dp){
        if(ind>=n) return 0;

        if(dp[ind][isBuy]!=-1) return dp[ind][isBuy];

        int buy=0, sell=0;

        if(isBuy==0){
            buy = helper(ind+1, n, 1, prices, fee, dp) - prices[ind];
            sell = helper(ind+1, n, 0, prices, fee, dp);
        }
        else{
            buy = helper(ind+1, n, 1, prices, fee, dp);
            sell = helper(ind+1, n, 0, prices, fee, dp) + prices[ind] - fee;
        }

        return dp[ind][isBuy] = Math.max(buy, sell);
    }
}