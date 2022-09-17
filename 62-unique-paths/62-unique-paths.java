class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i[] : dp) Arrays.fill(i,-1);
        
        return dfs(m-1,n-1,dp);
    }
    
    public int dfs(int row, int col, int[][] dp){
        if(row<0 || col<0) return 0;
        if(row==0 && col==0) return 1;
        
        if(dp[row][col] != -1) return dp[row][col];
        
        return dp[row][col] = dfs(row-1,col,dp)+dfs(row,col-1,dp);
    }
}