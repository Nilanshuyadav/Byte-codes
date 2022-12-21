class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length, col = mat[0].length;
        
        int[][] ans = new int[row][col];
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                int row_from = Math.max(0, r-k), row_to = Math.min(row-1, r+k);
                int col_from = Math.max(0, c-k), col_to = Math.min(col-1, c+k);
                
                int sum=0;
                
                for(int r_from = row_from; r_from<=row_to; r_from++){
                    for(int c_from = col_from; c_from<=col_to; c_from++)
                        sum += mat[r_from][c_from];
                }
                
                ans[r][c] = sum;
            }
        }
        
        return ans;
    }
}