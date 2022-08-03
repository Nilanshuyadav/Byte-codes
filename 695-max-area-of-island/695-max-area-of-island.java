class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int max = 0;
        
        for(int i =0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == 1){
                    max = Math.max(max,function(grid,i,j));
                }    
            }
        }
        
        return max;
    }
    
    public int function(int[][] grid, int row, int col){
        int duplicate_row = row, duplicate_col = col;
        grid[row][col] = 0;
        int sum=1;
        
        while(--row >= 0){
            if(grid[row][col] == 1)
                sum += function(grid,row,col);
            else break;
        }
        
        row = duplicate_row;
        
        while(++row < grid.length){
            if(grid[row][col] == 1)
                sum += function(grid,row,col);
            else break;
        }
        
        row = duplicate_row;
        
        while(--col >= 0){
            if(grid[row][col] == 1)
                sum += function(grid,row,col);
            else break;
        }
        
        col = duplicate_col;
        
        while(++col < grid[0].length){
            if(grid[row][col] == 1)
                sum += function(grid,row,col);
            else break;
        }
        
        return sum;
    }
}