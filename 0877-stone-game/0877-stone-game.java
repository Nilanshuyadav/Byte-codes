class Solution {
    boolean alice_wins;
    public boolean stoneGame(int[] piles) {
        alice_wins = false;
        int n = piles.length;
        
        Boolean[][][] dp = new Boolean[2][n][n];
        
        return dfs(1, 0, n-1, piles, 0, 0, dp);
    }
    
    public boolean dfs(int turn, int s, int e, int[] piles, int a_sum, int b_sum, Boolean[][][] dp){
        if(e<s){
            return a_sum>b_sum;
        }
        
        if(dp[turn][s][e] != null)
            return dp[turn][s][e];
        
        if(turn==1){
            return dp[turn][s][e] = dfs(0, s+1, e, piles, a_sum+piles[s], b_sum, dp) || dfs(0, s, e-1, piles, a_sum+piles[e], b_sum, dp);
        }
        else{
            return dp[turn][s][e] = dfs(1, s+1, e, piles, a_sum, b_sum+piles[s], dp) || dfs(1, s, e-1, piles, a_sum, b_sum+piles[e], dp);
        }
    }
}