class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int[] r = {-1,0,1,0}, c = {0,1,0,-1};
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<row;i++){
            if(grid[i][0]==1){grid[i][0]=0; q.add(new Pair(i,0));}
            if(grid[i][col-1]==1){grid[i][col-1]=0; q.add(new Pair(i,col-1));}
        }  
        
        for(int i=0;i<col;i++){
            if(grid[0][i]==1){grid[0][i]=0; q.add(new Pair(0,i));}
            if(grid[row-1][i]==1){grid[row-1][i]=0; q.add(new Pair(row-1,i));}
        }
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            for(int i=0;i<4;i++){
                int new_row = temp.row+r[i];
                int new_col = temp.col+c[i];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || grid[new_row][new_col]==0) continue;
                
                grid[new_row][new_col] = 0;
                q.add(new Pair(new_row,new_col));
            }
        }
        
        int ans = 0;
        
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(grid[i][j]==1)
                    ans++;
        
        return ans;
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