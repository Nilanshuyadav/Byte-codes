class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        
        int[] r = {-1,-1,0,1,1,1,0,-1} , c = {0,1,1,1,0,-1,-1,-1};
        
        if(n==1 && grid[0][0] == 0) return 1;
        
        Queue<Pair> q = new LinkedList<>();
        if(grid[0][0] == 0)
            q.add(new Pair(0,0));
        int cnt = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int j=0;j<size;j++){
                Pair temp = q.remove();
                
                for(int i=0;i<8;i++){
                    int new_row = temp.row + r[i];
                    int new_col = temp.col + c[i];
                    
                    if(new_row<0 || new_col<0 || new_row>=n || new_col>=n || vis[new_row][new_col]==true || grid[new_row][new_col]==1) continue;
                    
                    if(new_row == n-1 && new_col == n-1) return cnt+1;
                    
                    q.add(new Pair(new_row,new_col));
                    vis[new_row][new_col] = true;
                }
            }
            cnt++;
        }
        
        return -1;
    }
}

class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}