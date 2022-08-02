class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        int count = 0;
        for(int i =0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == '1'){
                    function(grid,i,j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void function(char[][] grid, int row, int col){
        
        grid[row][col] = '0';
        
        int duplicate_row = row, duplicate_col = col;
        int row_length = grid.length,col_length = grid[0].length;
        
        while(--row >= 0){
            if(grid[row][col] == '1')
                function(grid,row,col);
            else break;
        }
        
        row = duplicate_row;
        
        while(++row < row_length){
            if(grid[row][col] == '1')
                function(grid,row,col);
            else break;
        }
        
        row = duplicate_row;
        
        while(--col >=0){
            if(grid[row][col] == '1')
                function(grid,row,col);
            else break;
        }
        
        col = duplicate_col;
        
        while(++col < col_length){
            if(grid[row][col] == '1')
                function(grid,row,col);
            else break;
        }
    }
}