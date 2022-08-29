class Solution {
    int[] r = {-1,0,1,0} , c = {0,1,0,-1};
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        int ans = 0;
        
        for(int i = 0;i<row;i++)
            for(int j=0;j<col;j++)
                if(grid[i][j] == '1'){
                    ans++;
                    grid[i][j] = '0';
                    function(grid,i,j);
                }
        
        return ans;
    }
    
    public void function(char[][] grid, int row, int col){
        for(int i=0;i<4;i++){
            int new_row = row+r[i];
            int new_col = col+c[i];
            
            if(new_row<0 || new_col<0 || new_row>=grid.length || new_col>=grid[0].length || grid[new_row][new_col]=='0') continue;
            grid[new_row][new_col] = '0';
            function(grid,new_row,new_col);
        }
    }
}