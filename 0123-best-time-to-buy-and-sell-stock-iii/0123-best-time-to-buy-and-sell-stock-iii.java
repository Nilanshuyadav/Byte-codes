class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] ind : dp)
            for(int[] inx : ind)
                Arrays.fill(inx, -1);
        
        return dfs(1, 0, prices, 2, dp);
    }
    
    public int dfs(int buy, int ind, int[] prices, int k, int[][][] dp){
        if(k<=-1 || ind == prices.length)
            return 0;
        
        if(dp[ind][buy][k] != -1)
            return dp[ind][buy][k];
        
        int price = 0;
        
        if(buy==1){
            price = Math.max(-prices[ind]+dfs(0, ind+1, prices, k-1, dp), dfs(1, ind+1, prices, k, dp));
        }
        else{
            price = Math.max(+prices[ind]+dfs(1, ind+1, prices, k, dp), dfs(0, ind+1, prices, k, dp));
        }
        
        return dp[ind][buy][k] = price;
    }
}