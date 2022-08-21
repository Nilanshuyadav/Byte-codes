class Solution {
    Queue<int[]> q;
    int[] r = {-1,0,1,0}, c = {0,1,0,-1};
    public int shortestBridge(int[][] grid) {
        q = new LinkedList<>();
        int n = grid.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i,j});
                    function(grid,i,j);
                    i=n;
                    j=n;
                }    
                    
            }
        }
        
        int cnt =0 ;
        while(!q.isEmpty()){
            cnt++;
            int size = q.size();
            
            for(int j=0;j<size;j++){
                int[] temp = q.remove();
                for(int i=0;i<4;i++){
                    int new_row = temp[0]+r[i];
                    int new_col = temp[1]+c[i];
                    
                    if(new_row<0 || new_row>=n || new_col<0 || new_col>=n) continue;
                    if(grid[new_row][new_col] == 1) return cnt-1;
                    if(grid[new_row][new_col] == 0) {
                        q.add(new int[]{new_row,new_col});
                        grid[new_row][new_col] = 2;
                    }                                 
                }
            }
        }
        return -1;
    }
    
    public void function(int[][] grid, int row, int col){
        grid[row][col] = 0;
        int n = grid.length;
        
        for(int i=0;i<4;i++){
            int new_row = row+r[i];
            int new_col = col+c[i];
            
            if(new_row<0 || new_col<0 || new_row>=n || new_col>=n) continue;
            if(grid[new_row][new_col] != 0){
                q.add(new int[]{new_row,new_col});
                function(grid,new_row,new_col);
            }
        }
    }
}