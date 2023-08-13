class Solution {
    int[] r_arr={0, -1}, c_arr={-1, 0};
    
    public int uniquePathsWithObstacles(int[][] m) {
        int row = m.length, col = m[0].length;
        
        int[][] dp = new int[row][col];
        
        for(int ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        return m[row-1][col-1]==1 ? 0 : solve(row-1, col-1, row, col, m, dp);
    }
    
    public int solve(int r, int c, int row, int col, int[][] m, int[][] dp){
        if(r==0 && c==0){
            return 1;
        }
        
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        
        int new_r, new_c, ans=0;
        
        for(int ind=0; ind<2; ind++){
            new_r = r+r_arr[ind];
            new_c = c+c_arr[ind];
            
            if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || m[new_r][new_c]==1)
                continue;
            
            ans += solve(new_r, new_c, row, col, m, dp);
        }
        
        return dp[r][c] = ans;
    }
}