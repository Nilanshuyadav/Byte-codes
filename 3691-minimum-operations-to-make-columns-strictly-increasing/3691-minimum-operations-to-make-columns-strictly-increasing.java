class Solution {
    public int minimumOperations(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int sum=0, temp;

        for(int c=0; c<col; c++){
            for(int r=1; r<row; r++){
                temp = Math.max(0, grid[r-1][c] - grid[r][c] + 1);

                sum += temp;
                grid[r][c] += temp;
            }
        }

        return sum;
    }
}