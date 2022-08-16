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
        
        if(sr-1>=0 && grid[sr-1][sc] == '1')
            function(grid,sr-1,sc,row,col);
        if(sr+1<row && grid[sr+1][sc] == '1')
            function(grid,sr+1,sc,row,col);
        if(sc-1>=0 && grid[sr][sc-1] == '1')
            function(grid,sr,sc-1,row,col);
        if(sc+1<col && grid[sr][sc+1]=='1')
            function(grid,sr,sc+1,row,col);
    }
}