class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return solve(m-1, n-1, m, n, dp);
    }
    
    public int solve(int r, int c, int m, int n, int[][] dp){
        if(r==0 && c==0){
            return 1;
        }
        
        if(r<0 || c<0 || r>=m || c>=n) return 0;
        
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        
        return dp[r][c] = solve(r-1, c, m, n, dp)+solve(r, c-1, m, n, dp);
    }
}