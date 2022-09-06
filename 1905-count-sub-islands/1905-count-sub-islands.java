class Solution {
    int[] r = {-1,0,1,0} , c = {0,1,0,-1};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int row = grid2.length, col = grid2[0].length,cnt = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid2[i][j] == 1){
                    if(dfs(grid1,grid2,i,j))
                        cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public boolean dfs(int[][] grid1, int[][] grid2, int row, int col){
        boolean bool = true;
        if(grid1[row][col] != grid2[row][col]) bool = false;
        
        grid2[row][col] = 0;
        
        for(int i=0;i<4;i++){
            int new_row = row+r[i];
            int new_col = col+c[i];
            
            if(new_row<0 || new_col<0 || new_row>=grid2.length || new_col>=grid2[0].length || grid2[new_row][new_col]==0) continue;
            
            bool = dfs(grid1,grid2,new_row,new_col) && bool;
        }
        
        return bool;
    }
}