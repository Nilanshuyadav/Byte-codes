class Solution {
    int ans;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int max=0;
        ans = 0;
        for(int  i=0;i<row;i++){
            for(int j =0 ;j<col;j++){
                if(grid[i][j] == 1){
                    max = Math.max(max,function(grid,i,j));
                    ans = 0;
                } 
            }
        }
        return max;
    }
    
    public int function(int[][] grid,int row,int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0) return 0;
        
        ans++;
        grid[row][col] = 0;
        function(grid,row-1,col);
        function(grid,row+1,col);
        function(grid,row,col-1);
        function(grid,row,col+1);
        
        return ans;
    }
}