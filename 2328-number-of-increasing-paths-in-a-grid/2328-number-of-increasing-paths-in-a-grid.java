class Solution {
    public int countPaths(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        long sum=0;
        
        int[][] dp = new int[row][col];
        
        for(int ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(dp[r][c] != -1){
                    sum = (sum+dp[r][c])%1000000007;
                }
                else{
                    sum = (sum+solve(r,c,row, col, grid, dp))%1000000007;
                }        
            }
        }
        
        return (int)sum;
    }
    
    int[] r_arr={-1,0,1,0}, c_arr={0,1,0,-1};
    
    public long solve(int r, int c, int row, int col, int[][] grid, int[][] dp){
        long sum=1;
        
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        
        int new_r, new_c;
        for(int ind=0; ind<4; ind++){
            new_r = r+r_arr[ind];
            new_c = c+c_arr[ind];
            
            if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || grid[new_r][new_c]<=grid[r][c])
                continue;
            
            sum = (sum+solve(new_r, new_c, row, col, grid, dp))%1000000007;
        }
        
        return dp[r][c] = (int)sum;
    }
}