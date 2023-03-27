class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        
        int[][] dp = new int[row][col];
        dp[row-1][col-1] = grid[row-1][col-1];
        
        
        for(int r=row-2; r>=0; r--){
            dp[r][col-1] = dp[r+1][col-1]+grid[r][col-1];
        }
        
        for(int c=col-2; c>=0; c--){
            dp[row-1][c] = dp[row-1][c+1]+grid[row-1][c];
        }
        
        for(int r=row-2; r>=0; r--){
            for(int c=col-2; c>=0; c--){
                dp[r][c] = Math.min(dp[r+1][c], dp[r][c+1])+grid[r][c];
            }
        }
        
        return dp[0][0];
    }
}