class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int ind[] : dp)
            Arrays.fill(ind, -1);
        
        for(int col = 0; col<matrix[0].length; col++)
            min = Math.min(min, dfs(0, col, matrix, dp));
        
        return min;
    }
    
    public int dfs(int row, int col, int[][] matrix, int[][] dp){
        if(row == matrix.length-1)
            return matrix[row][col];
        
        if(dp[row][col] != -1)
            return dp[row][col];
        
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        
        if(col>0)
            left = dfs(row+1, col-1, matrix, dp);
        
        int bottom = dfs(row+1, col, matrix, dp);
        
        if(col<matrix[0].length-1)
            right = dfs(row+1, col+1, matrix, dp);
        
        return dp[row][col] = matrix[row][col] + Math.min(left, Math.min(bottom, right));
    }
}