class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int max,ans = 0;
        for(int  i=0;i<row;i++){
            for(int j =0 ;j<col;j++){
                if(grid[i][j] == 1){
                    max = function(grid,i,j);
                    if(max > ans)ans = max;
                } 
            }
        }
        return ans;
    }
    
    public int function(int[][] grid,int row,int col){
        int sum = 1;
        grid[row][col] = 0;
        
        if(row-1 >=0 && grid[row-1][col] == 1) sum += function(grid,row-1,col);
        if(row+1 <grid.length && grid[row+1][col] == 1) sum += function(grid,row+1,col);
        if(col-1 >=0 && grid[row][col-1] == 1) sum += function(grid,row,col-1);
        if(col+1 < grid[0].length && grid[row][col+1] == 1) sum += function(grid,row,col+1);
        
        return sum;
    }
}