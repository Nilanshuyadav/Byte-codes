class Solution {
    public int closedIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int count = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 0 && function(grid,i,j,row,col)){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public boolean function(int[][] grid, int row, int col, int row_length, int col_length){
        boolean temp = true;
        grid[row][col] = 1;
        
        if(row-1 >= 0 && grid[row-1][col] == 0)
            if(!function(grid,row-1,col,row_length,col_length))
                temp = false;
            //temp = temp && function(grid,row-1,col,row_length,col_length);
        
        if(row+1 < row_length && grid[row+1][col] == 0)
            if(!function(grid,row+1,col,row_length,col_length))
                temp = false;
            //temp = temp && function(grid,row+1,col,row_length,col_length);
        
        if(col-1 >= 0 && grid[row][col-1] == 0)
            if(!function(grid,row,col-1,row_length,col_length))
                temp = false;
            //temp = temp && function(grid,row,col-1,row_length,col_length);
        
        if(col+1 < col_length && grid[row][col+1] == 0)
            if(!function(grid,row,col+1,row_length,col_length))
                temp = false;
            //temp = temp && function(grid,row,col+1,row_length,col_length);
        
        
        if(row == 0 || row == row_length-1 || col == 0 || col == col_length-1)
            return false;
        
        return temp;
    }
}