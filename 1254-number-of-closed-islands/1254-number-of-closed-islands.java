class Solution {
    public int closedIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length,cnt = 0;
        
        for(int i=0;i<row;i++){ 
            if(grid[i][0] == 0) function(grid,i,0); 
            if(grid[i][col-1] == 0) function(grid,i,col-1);
        }
        for(int i=0;i<col;i++){
            if(grid[0][i] == 0) function(grid,0,i);
            if(grid[row-1][i] == 0) function(grid,row-1,i);
        }    
        
        for(int i=1;i<row-1;i++){
            for(int j=1;j<col-1;j++){
                if(grid[i][j] == 0){
                    cnt++;
                    function(grid,i,j);
                }
            }
        }
        return cnt;
    }
    
    public void function(int[][] grid,int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==1) return;
        grid[row][col] = 1;
        function(grid,row-1,col);
        function(grid,row+1,col);
        function(grid,row,col-1);
        function(grid,row,col+1);
    }
}