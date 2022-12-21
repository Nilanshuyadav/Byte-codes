class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length, col = mat[0].length;
        
        int[][] dp = new int[row][col];
        int sum = 0;
        
        for(int r=0; r<row; r++){
            sum = 0;
            
            for(int c=0; c<col; c++){
                sum += mat[r][c];
                
                dp[r][c] = sum;
            }
        }
        
        int[][] ans = new int[row][col];
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                int row_from = Math.max(0,r-k), row_to = Math.min(row-1,r+k);
                int col_from = Math.max(0,c-k), col_to = Math.min(col-1,c+k);
                
                sum = 0;
                
                for(int r_ind=row_from; r_ind<=row_to; r_ind++){
                    sum += dp[r_ind][col_to]-dp[r_ind][col_from]+mat[r_ind][col_from];
                }
                
                ans[r][c] = sum;
            }
        }
        
        return ans;
    }
}