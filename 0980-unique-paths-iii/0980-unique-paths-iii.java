class Solution {
    int[] r_arr = {-1,0,1,0}, c_arr={0,1,0,-1};
    
    public int uniquePathsIII(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int available_box = 0;
        
        int start[] = new int[2];
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == 0)
                    available_box++;
                else if(grid[r][c] == 1){
                    start[0] = r;
                    start[1] = c;
                }
            }
        }
        
        return solve(start[0], start[1], grid, -1, available_box);
    }
    
    public int solve(int row, int col, int[][] grid, int count, int avail){        
        if(grid[row][col] == 2){
            if(count==avail)
                return 1;
            else return 0;
        }
        
        grid[row][col] = 1;
        
        int temp = 0;
        
        for(int ind=0; ind<4; ind++){
            int new_row = row+r_arr[ind];
            int new_col = col+c_arr[ind];
            
            if(new_row<0 || new_col<0 || new_row>=grid.length || new_col>=grid[0].length || grid[new_row][new_col]==-1 || grid[new_row][new_col]==1)
                continue;
            
            temp += solve(new_row, new_col, grid, count+1, avail);
        }
        
        grid[row][col] = 0;
        
        return temp;
    }
}