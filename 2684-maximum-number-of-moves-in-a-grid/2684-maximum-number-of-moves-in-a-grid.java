class Solution {
    public int maxMoves(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int max = 0;
        int[][] dp = new int[row][col];
        
        for(int ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        for(int ind=0; ind<row; ind++){
            max = Math.max(max, solve(ind, 0, grid, row, col, dp));
        }
        
        return max;
    }
    
    int[] r_arr = {-1, 0 , 1};
    
    public int solve(int r, int c, int[][] grid, int row, int col, int[][] dp){
        int new_r, new_c;
        int max = 0;
        
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        
        for(int ind=0; ind<3; ind++){
            new_r = r+r_arr[ind];
            new_c = c+1;
            
            if(new_r<0 || new_r>=row || new_c<0 || new_c>=col || grid[new_r][new_c]<=grid[r][c])
                continue;
            
            max = Math.max(max, solve(new_r, new_c, grid, row, col, dp) + 1);
        }
        
        return dp[r][c] = max;
    }
}