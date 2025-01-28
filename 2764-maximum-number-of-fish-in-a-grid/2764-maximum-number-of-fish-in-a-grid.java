class Solution {
    int[] r_arr = {-1,0,1,0}, c_arr={0,1,0,-1};
    boolean[][] vis;

    public int findMaxFish(int[][] grid) {
        int max = 0, totalFish=0;
        int row = grid.length, col = grid[0].length;
        vis = new boolean[row][col];

        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] != 0 && !vis[r][c]){
                    totalFish = helper(r, c, grid, row, col);

                    max = Math.max(totalFish, max);
                }
            }
        }

        return max;
    }

    public int helper(int r, int c, int[][] grid, int row, int col){
        int sum = grid[r][c];
        int new_r, new_c;
        vis[r][c] = true;
        
        for(int i=0; i<4; i++){
            new_r = r + r_arr[i];
            new_c = c + c_arr[i];

            if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || vis[new_r][new_c] || grid[new_r][new_c]==0) continue;

            sum += helper(new_r, new_c, grid, row, col);
        }

        return sum;
    }
}