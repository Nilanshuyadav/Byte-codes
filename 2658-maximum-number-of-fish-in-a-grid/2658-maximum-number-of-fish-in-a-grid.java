class Solution {
    int[] r_arr={-1, 0, 1, 0}, c_arr={0, 1, 0, -1};
    
    public int findMaxFish(int[][] grid) {
        int row=grid.length, col=grid[0].length;
        boolean[][] vis = new boolean[row][col];
        
        int max=0;
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c]>0 && !vis[r][c]){
                    max = Math.max(max, solve(r, c, grid, vis));
                }
            }
        }
        
        return max;
    }
    
    public int solve(int r, int c, int[][] grid, boolean[][] vis){
        vis[r][c] = true;
        int sum=0, new_r, new_c;
        
        for(int ind=0; ind<4; ind++){
            new_r = r+r_arr[ind];
            new_c = c+c_arr[ind];
            
            if(new_r<0 || new_c<0 || new_r>=grid.length || new_c>=grid[0].length || grid[new_r][new_c]==0 || vis[new_r][new_c])
                continue;
            
            sum += solve(new_r, new_c, grid, vis);
        }
        
        return sum + grid[r][c];
    }
}