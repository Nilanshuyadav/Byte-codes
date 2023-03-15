class Solution {
    int max = (int)1e8;
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        int[] dp = new int[amount+1], curr = new int[amount+1], temp;
    
        Arrays.fill(dp, max);
        Arrays.fill(curr, max);
        
        for(int ind=0; ind<=amount; ind++){
            if(ind%coins[0] == 0){
                dp[ind] = ind/coins[0];
            }
        }
        
        
        int pick = max, not_pick = max;
        
        for(int ind=1; ind<n; ind++){
            for(int amo=0; amo<=amount; amo++){
                pick = max;

                if(amo>=coins[ind]){
                    pick = 1 + curr[amo-coins[ind]];
                }

                not_pick = dp[amo];


                curr[amo] = Math.min(pick, not_pick);
            }
            
            temp = dp;
            dp = curr;
            curr = temp;
            
            Arrays.fill(curr, max);
        }
        
        return dp[amount]==max? -1 : dp[amount];
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