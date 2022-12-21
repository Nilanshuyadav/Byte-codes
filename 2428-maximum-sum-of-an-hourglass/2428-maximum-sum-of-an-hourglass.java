class Solution {
    public int maxSum(int[][] grid) {
        int row = grid.length, col = grid[0].length, max = 0;
        
        for(int r=1; r<row-1; r++){
            for(int c=1; c<col-1; c++){
                max = Math.max(max, dfs(r,c,grid));
            }
        }
        
        return max;
    }
    
    public int dfs(int row, int col, int[][] grid){
        int sum = 0;
        
        sum += grid[row][col];
        sum += grid[row-1][col];
        sum += grid[row-1][col-1];
        sum += grid[row-1][col+1];
        sum += grid[row+1][col];
        sum += grid[row+1][col-1];
        sum += grid[row+1][col+1];
        
        return sum;
    }
}