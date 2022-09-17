class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(row==0 && col==0){dp[0][0] = 1; continue;}
                if(col!=0) dp[row][col] = dp[row][col-1];
                if(row!=0) dp[row][col] += dp[row-1][col];
            }
        }
        
        return dp[m-1][n-1];
    }
}