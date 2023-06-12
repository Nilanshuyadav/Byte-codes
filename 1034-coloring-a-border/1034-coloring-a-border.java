class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int temp = grid[row][col];
        
        solve(row, col, grid, grid.length, grid[0].length, color);
        
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] == -1){
                    grid[r][c] = color;
                }
                else if(grid[r][c] == -2){
                    grid[r][c] = temp;
                }
            }
        }
        
        return grid;
    }
    
    int[] r_arr = {-1, 0, 1, 0}, c_arr={0, 1, 0, -1};
    public void solve(int r, int c, int[][] grid, int row, int col, int color){
        int temp = grid[r][c];
        
        int ind=0;
        int new_r, new_c;
        for(ind=0; ind<4; ind++){
            new_r = r+r_arr[ind];
            new_c = c+c_arr[ind];
            
            if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || (grid[new_r][new_c]!=temp && grid[new_r][new_c]!=-1 && grid[new_r][new_c]!=-2)){
                grid[r][c] = -1;
                break;
            }
        }
        
        if(ind == 4){
            grid[r][c] = -2;
        }
        
        for(ind=0; ind<4; ind++){
            new_r = r+r_arr[ind];
            new_c = c+c_arr[ind];
            
            if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || grid[new_r][new_c]==-1 || grid[new_r][new_c]==-2 || grid[new_r][new_c]!=temp){
                continue;
            }
            
            solve(new_r, new_c, grid, row, col, color);
        }
    }
}