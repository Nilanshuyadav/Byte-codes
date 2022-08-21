class Solution {
    int[] r = {-1,0,1,0}, c = {0,1,0,-1};
    public int shortestBridge(int[][] grid) {
       int n = grid.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    function(grid,i,j);
                    i = n;
                    j = n;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){grid[i][j] = -1; q.add(new int[]{i,j});}
            }
        
        int cnt = -1;
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            for(int i=0;i<size;i++){
                int[] temp = q.remove();
                for(int j=0;j<4;j++){
                    int nr = temp[0]+r[j];
                    int nc = temp[1]+c[j];
                    
                    if(nr<0 || nc<0 || nr>=n || nc>=n) continue;
                    if(grid[nr][nc] == 2) return cnt;
                    if(grid[nr][nc] == 0){
                        grid[nr][nc] = -1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return -1;
    }
    
    public void function(int[][] grid, int row, int col){
        grid[row][col] = 2;
        int n = grid.length;
        for(int i=0;i<4;i++){
            int nr = row+r[i];
            int nc = col+c[i];
            
            if(nr<0 || nc<0 || nr>=n || nc>=n) continue;
            if(grid[nr][nc] == 1) function(grid,nr,nc);
        }
    }
}