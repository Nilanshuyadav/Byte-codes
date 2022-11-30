class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        
        int[] col_arr = new int[col];
        int[] row_arr = new int[row];
        
        for(int r=0; r<row; r++)
            for(int c=0; c<col; c++)
                if(grid[r][c] == 0)
                    grid[r][c] = -1;
        
        for(int r=0; r<row; r++){
            int temp = 0;
            for(int c=0; c<col; c++){
                col_arr[c] += grid[r][c];
                temp += grid[r][c];
            }
            
            row_arr[r] = temp;
        }
        
        int[][] diff = new int[row][col];
        
        for(int r=0; r<row; r++)
            for(int c=0; c<col; c++)
                diff[r][c] = row_arr[r]+col_arr[c];
        
        return diff;
    }
}