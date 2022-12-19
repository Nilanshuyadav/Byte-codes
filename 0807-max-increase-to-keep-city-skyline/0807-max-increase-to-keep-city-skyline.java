class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        
        int[] r_arr = new int[n], c_arr = new int[n];
        
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                r_arr[r] = Math.max(r_arr[r], grid[r][c]);
                c_arr[c] = Math.max(c_arr[c], grid[r][c]);
            }
        }
        
        int sum = 0;
        
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                sum += Math.min(r_arr[r], c_arr[c]) - grid[r][c];
            }
        }
        
        return sum;
    }
}