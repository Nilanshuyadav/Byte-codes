class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length,col = grid[0].length;
        int cnt = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    function(grid,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void function(char[][] grid, int sr, int sc){
        grid[sr][sc] = '0';
        
        if(sr-1>=0 && grid[sr-1][sc] == '1')
            function(grid,sr-1,sc);
        if(sr+1<grid.length && grid[sr+1][sc] == '1')
            function(grid,sr+1,sc);
        if(sc-1>=0 && grid[sr][sc-1] == '1')
            function(grid,sr,sc-1);
        if(sc+1<grid[0].length && grid[sr][sc+1]=='1')
            function(grid,sr,sc+1);
    }
}