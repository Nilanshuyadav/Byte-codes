class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        
        for(int i=0;i<row;i++){
            if(grid[i][0] == 1) function(grid,i,0);
            if(grid[i][col-1] == 1) function(grid,i,col-1);
        }
        
        for(int i=0;i<col;i++){
            if(grid[0][i] == 1) function(grid,0,i);
            if(grid[row-1][i] == 1) function(grid,row-1,i);
        }
        
        int ans = 0;
        
        for(int i=0;i<row;i++){
            for(int j =0;j<col;j++){
                if(grid[i][j] == 1){
                    ans += function(grid,i,j);
                }
            }
        }
        return ans;
    }
    
    public int function(int[][] grid,int row,int col){
        int area = 1;
        grid[row][col] = 0;
        if(row-1>=0 && grid[row-1][col] == 1)area += function(grid,row-1,col);
        if(row+1<grid.length && grid[row+1][col] == 1) area += function(grid,row+1,col);
        if(col-1>=0 && grid[row][col-1] == 1)area += function(grid,row,col-1);
        if(col+1<grid[0].length && grid[row][col+1] == 1)area += function(grid,row,col+1);
        
        return area;
    }
}