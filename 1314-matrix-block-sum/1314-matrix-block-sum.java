class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length, col=mat[0].length;
        
        int[][] dp = new int[row][col];
        int sum = 0;
        
        for(int r=0; r<row; r++){
            sum = 0;
            
            for(int c=0; c<col; c++){
                sum += mat[r][c];
                
                dp[r][c] = sum;
                
                if(r>0){
                    dp[r][c] += dp[r-1][c];
                }
            }
        }
        
        int[][] ans = new int[row][col];
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                int row_from = Math.max(0, r-k), row_to = Math.min(row-1, r+k);
                int col_from = Math.max(0, c-k), col_to = Math.min(col-1, c+k);
                
                int total = dp[row_to][col_to];
                
                if(row_from>0){
                    total -= dp[row_from-1][col_to];
                }
                
                if(col_from>0){
                    total -= dp[row_to][col_from-1];
                }
                
                if(row_from>0 && col_from>0){
                    total += dp[row_from-1][col_from-1];
                }
                
                ans[r][c] = total;
            }
        }
        
        return ans;
    }
}