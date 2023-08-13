class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1], curr = new int[amount+1];
        
        curr[0] = 1;
        
        int pick, not_pick;
        
        for(int r=0; r<n; r++){
            for(int c=1; c<=amount; c++){
                pick=0;
                not_pick=0;
                
                if(coins[r]<=c){
                    pick = curr[c-coins[r]];
                }
                
                if(r>0){
                    not_pick = dp[c];
                }    
                
                curr[c] = pick+not_pick;
            }
            
            for(int ind=0; ind<=amount; ind++){
                dp[ind] = curr[ind];
            }
        }
        
        return curr[amount];
        
//         for(int ind[] : dp){
//             Arrays.fill(ind, -1);
//         }
        
//         return solve(0, coins, amount, dp);
    }
    
//     public int solve(int ind, int[] coins, int amount, int[][] dp){
//         if(ind==coins.length){
//             return 0;
//         }
        
//         if(amount == 0){
//             return 1;
//         }
        
//         if(dp[amount][ind] != -1){
//             return dp[amount][ind];
//         }
        
//         int pick=0, not_pick=0;
        
//         if(coins[ind]<=amount){
//             pick = solve(ind, coins, amount-coins[ind], dp);
//         }
        
//         not_pick = solve(ind+1, coins, amount, dp);
        
//         return dp[amount][ind] = pick + not_pick;
//     }
}