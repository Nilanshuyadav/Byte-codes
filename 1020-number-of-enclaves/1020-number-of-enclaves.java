class Solution {
    int[] r = {-1,0,1,0}, c = {0,1,0,-1};
    public int numEnclaves(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        
        for(int i=0;i<row;i++){
            if(grid[i][0] == 1){grid[i][0]=0; dfs(grid,i,0);}
            if(grid[i][col-1]==1){grid[i][col-1]=0; dfs(grid,i,col-1);}
        }
        
        for(int i=0;i<col;i++){
            if(grid[0][i]==1){grid[0][i]=0; dfs(grid,0,i);}
            if(grid[row-1][i]==1){grid[row-1][i]=0; dfs(grid,row-1,i);}
        }
        
        int ans = 0;
        
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(grid[i][j] == 1) ans++;
        
        return ans;
    }
    
    public void dfs(int[][] grid, int row, int col){
        for(int i=0;i<4;i++){
            int new_row = row+r[i];
            int new_col = col+c[i];
            
            if(new_row<0 || new_col<0 || new_row>=grid.length || new_col>=grid[0].length || grid[new_row][new_col]==0) continue;
            
            grid[new_row][new_col]=0;
            dfs(grid,new_row,new_col);
        }
    }
}