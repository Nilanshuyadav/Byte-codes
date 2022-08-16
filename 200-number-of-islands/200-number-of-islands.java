class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length,col = grid[0].length;
        int cnt = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    function(grid,i,j,row,col);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void function(char[][] grid, int sr, int sc, int row, int col){
        grid[sr][sc] = '0';
        
        int[] r={-1,1,0,0}, c={0,0,-1,1};
        
        for(int i=0;i<4;i++){
            int ro = sr+r[i];
            int co = sc+c[i];
            
            if(ro>=0 && ro<row && co>=0 && co<col && grid[ro][co] == '1')
                function(grid,ro,co,row,col);
        }
    }
}