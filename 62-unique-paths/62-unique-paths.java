class Solution {
    public int uniquePaths(int m, int n) {
        int i = 0,j=0;
        int[][] dp = new int[m][n];
        return uniquepath(i,j,m,n,dp);
    }
    
    private int uniquepath(int i,int j, int m, int n, int[][] dp){
        if(i==m-1 && j==n-1) return 1;
        if(i>=m || j>=n) return 0;
        
        if(dp[i][j] != 0) return dp[i][j];
        return dp[i][j] = uniquepath(i+1,j,m,n,dp)+uniquepath(i,j+1,m,n,dp);
    }
}