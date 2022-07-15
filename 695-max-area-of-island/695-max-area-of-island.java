class Solution {
    boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        
        int max = Integer.MIN_VALUE;
        
        visited = new boolean[row][col];
        
        for(int drow = 0;drow<row;drow++)
            for(int dcol = 0;dcol<col;dcol++)
                if(grid[drow][dcol] == 1 && visited[drow][dcol] == false){
                    int area = helper(drow,dcol,grid,row,col);
                    max = area > max? area:max;
                }
        
        return max==Integer.MIN_VALUE? 0:max;
    }
    
    public int helper(int row, int col, int[][] grid, int row_length, int col_length){
        visited[row][col] = true;
        
        int sum = 1;
        
        if(row+1 < row_length && grid[row+1][col] == 1 && visited[row+1][col] == false)
            sum += helper(row+1,col,grid,row_length,col_length);
        
        if(row-1 >= 0 && grid[row-1][col] == 1 && visited[row-1][col] == false)
            sum += helper(row-1,col,grid,row_length,col_length);
        
        if(col+1 < col_length && grid[row][col+1] == 1 && visited[row][col+1] == false)
            sum += helper(row,col+1,grid,row_length,col_length);
        
        if(col-1 >= 0 && grid[row][col-1] == 1 && visited[row][col-1] == false)
            sum += helper(row,col-1,grid,row_length,col_length);
        
        return sum;
    }
}