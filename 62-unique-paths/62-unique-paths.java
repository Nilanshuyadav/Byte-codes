class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        
        for(int row=0;row<m;row++){
            int[] temp = new int[n];
            for(int col=0;col<n;col++){
                if(row==0 && col==0){temp[col] = 1; continue;}
                if(row!=0) temp[col] = dp[col];
                if(col!=0) temp[col] += temp[col-1];
            }
            dp = temp;
        }
        return dp[n-1];
    }
}