class Solution {
    int[] r = {-1,0,1,0},c={0,1,0,-1};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int max = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1)
                    max = Math.max(max,dfs(grid,i,j));
            }
        }

        return max;
    }
    
    public int dfs(int[][] grid, int row, int col){
        grid[row][col] = 0;
        int sum = 0;
        
        for(int i=0;i<4;i++){
            int new_row = row+r[i];
            int new_col = col+c[i];
            
            if(new_row<0 || new_col<0 || new_row>=grid.length || new_col>=grid[0].length || grid[new_row][new_col]!=1) continue;
            
            sum += dfs(grid,new_row,new_col);
        }
        
        return sum+1;
    }
}