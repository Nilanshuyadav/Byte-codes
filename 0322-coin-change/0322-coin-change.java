class Solution {
    int max = (int)1e8;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int ind[] : dp)
            Arrays.fill(ind, -1);

        int temp = solve(n-1, coins, amount, dp);
        return temp>=max ? -1 : temp;
    }
    
    public int solve(int ind, int[] coins, int amount, int[][] dp){
        if(ind==0){
            return amount%coins[0] == 0? amount/coins[0] : max;
        }
        
        if(dp[ind][amount] != -1)
            return dp[ind][amount];
        
        int pick = max, not_pick=max, min;
        
        if(amount>=coins[ind]){
            pick = 1 + solve(ind, coins, amount-coins[ind], dp);
        }
        
        not_pick = solve(ind-1, coins, amount, dp);

        
        min = Math.min(pick, not_pick);
        
        return dp[ind][amount] = min>=max ? max : min;
    }
}