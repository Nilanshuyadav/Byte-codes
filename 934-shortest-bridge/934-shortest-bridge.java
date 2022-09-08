class Solution {
    Queue<Pair> q;
    int[] r = {-1,0,1,0}, c = {0,1,0,-1};
    public int shortestBridge(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        q = new LinkedList<>();
        
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(grid[i][j]==1){
                    grid[i][j]=2;
                    q.add(new Pair(i,j));
                    dfs(grid,i,j);
                    j=col;
                    i=row;
                }
    
        int cnt = -1;
        
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            while(size-->0){
                Pair temp = q.remove();
                for(int i=0;i<4;i++){
                    int new_row = temp.row+r[i];
                    int new_col = temp.col+c[i];
                    
                    if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || grid[new_row][new_col]==2) continue;
                    
                    if(grid[new_row][new_col]==1) return cnt;
                    grid[new_row][new_col] = 2;
                    q.add(new Pair(new_row, new_col));
                }
            }
        }
        return 0;
    }
    
    public void dfs(int[][] grid, int row, int col){
        for(int i=0;i<4;i++){
            int new_row = row+r[i];
            int new_col = col+c[i];
            
            if(new_row<0 || new_col<0 || new_row>=grid.length || new_col>=grid[0].length || grid[new_row][new_col]!=1)continue;
            grid[new_row][new_col] = 2;
            q.add(new Pair(new_row,new_col));
            dfs(grid,new_row,new_col);
        }
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