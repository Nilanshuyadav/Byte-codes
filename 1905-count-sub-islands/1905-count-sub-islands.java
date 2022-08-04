class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int row = grid2.length, col = grid2[0].length;
        int count = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid2[i][j] == 1 && function(grid2,i,j,grid1)){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public boolean function(int[][] grid2, int row, int col,int[][] grid1){
        boolean temp = true;
        
        grid2[row][col] = 0;
        
        if(row-1 >= 0 && grid2[row-1][col] == 1)
            temp = function(grid2,row-1,col,grid1) && temp;
        
        if(row+1 < grid2.length && grid2[row+1][col] == 1)
            temp = function(grid2,row+1,col,grid1) && temp;
        
        if(col-1 >= 0 && grid2[row][col-1] == 1)
            temp = function(grid2,row,col-1,grid1) && temp;
        
        if(col+1<grid2[0].length && grid2[row][col+1] ==1)
            temp = function(grid2,row,col+1,grid1) && temp;
        
        if(1 != grid1[row][col]){
            return false;
        }
        
        return temp;
    }
}