class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int[][] dp = new int[n][10001];
        for(int ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        return solve(0, n, 5000, rods, dp);
    }
    
    public int solve(int ind, int n, int diff, int[] rods, int[][] dp){
        if(ind == n){
            return diff==5000 ? 0 : -(int)1e8;
        }
        
        if(dp[ind][diff] != -1){
            return dp[ind][diff];
        }
        
        int bucket1 = rods[ind] + solve(ind+1, n, diff-rods[ind], rods, dp);
        int bucket2 = solve(ind+1, n, diff+rods[ind], rods, dp);
        int bucket3 = solve(ind+1, n, diff, rods, dp);
        
        return dp[ind][diff] = Math.max(bucket1, Math.max(bucket2, bucket3));
    }
}