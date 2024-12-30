class Solution {
    public int maxProfit(int[] prices, int fee) {
       int n = prices.length;

        int[][] dp = new int[2][2];

        dp[1][0] = 0;
        dp[1][1] = 0;

        int buy=0, sell=0;

        for(int ind=n-1; ind>=0; ind--){
            for(int isBuy=0; isBuy<=1; isBuy++){
                if(isBuy==0){
                    buy = dp[1][1] - prices[ind];
                    sell = dp[1][0];
                }
                else{
                    buy = dp[1][1];
                    sell = dp[1][0] + prices[ind] - fee;
                }

                dp[0][isBuy] = Math.max(buy, sell);
            }

            dp[1][0] = dp[0][0];
            dp[1][1] = dp[0][1];
        }

        return dp[0][0];
    }
}