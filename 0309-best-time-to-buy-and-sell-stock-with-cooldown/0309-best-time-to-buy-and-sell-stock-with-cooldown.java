class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[3][2];

        int buy=0, sell=0;

        for(int ind=n-1; ind>=0; ind--){
            for(int isBuy=0; isBuy<=1; isBuy++){
                buy = 0;
                sell = 0;

                if(isBuy==0){
                    buy = dp[1][1] - prices[ind];
                    sell = dp[1][0];
                }
                else{
                    buy = dp[1][1];
                    sell = dp[2][0] + prices[ind];
                }

                dp[0][isBuy] = Math.max(buy, sell);
            }

            dp[2][0] = dp[1][0];
            dp[2][1] = dp[1][1];

            dp[1][0] = dp[0][0];
            dp[1][1] = dp[0][1];
        }

        return dp[0][0];
    }
}