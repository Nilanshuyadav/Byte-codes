class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        
        int[][] dp = new int[row][col];
        
        for(int ind[] : dp)
            Arrays.fill(ind, -1);
        
        return solve(row-1, col-1, dp, grid);
    }
    
    public int solve(int r, int c, int[][] dp, int[][] grid){
        if(r==0 && c==0){
            return grid[0][0];
        }
        
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length)
            return (int)1e8;
        
        if(dp[r][c] != -1)
            return dp[r][c];
        
        int left = solve(r, c-1, dp, grid);
        int up = solve(r-1, c, dp, grid);
        
        return dp[r][c] = Math.min(left, up) + grid[r][c];
    }
}