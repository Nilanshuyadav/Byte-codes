class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt = 0,row = grid2.length,col = grid2[0].length;
        
        for(int i=0;i<row;i++){
            for(int j =0;j<col;j++){
                if(grid2[i][j] == 1 && function(grid1,grid2,i,j)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public boolean function(int[][] grid1, int[][] grid2, int row, int col){
        boolean temp = true;
        if(grid2[row][col] != grid1[row][col])temp = false;
        
        grid2[row][col] = 0;
        
        if(row-1>=0 && grid2[row-1][col]==1) temp = function(grid1,grid2,row-1,col) && temp;
        if(row+1<grid1.length && grid2[row+1][col]==1) temp = function(grid1,grid2,row+1,col) && temp;
        if(col-1>=0 && grid2[row][col-1]==1) temp = function(grid1,grid2,row,col-1) && temp;
        if(col+1<grid1[0].length && grid2[row][col+1]==1) temp = function(grid1,grid2,row,col+1) && temp;
        
        return temp;
    }
}