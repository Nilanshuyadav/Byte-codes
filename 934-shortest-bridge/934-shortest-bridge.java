class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        
        Queue<Pair> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    q1.add(new Pair(i,j));
                    i=n;
                    j=n;
                }
            }
        }
        
        while(!q1.isEmpty()){
            Pair temp = q1.remove();
            q2.add(temp);
            
            int r = temp.row,c = temp.col;
            grid[r][c] = 0;
            vis[r][c] = true;
            
            if(r-1 >=0 && !vis[r-1][c] && grid[r-1][c] == 1){vis[r-1][c] = true; q1.add(new Pair(r-1,c));}
            if(r+1 < n && !vis[r+1][c] && grid[r+1][c] == 1){vis[r+1][c] = true; q1.add(new Pair(r+1,c));}
            if(c-1 >=0 && !vis[r][c-1] && grid[r][c-1] == 1){vis[r][c-1] = true; q1.add(new Pair(r,c-1));}
            if(c+1 < n && !vis[r][c+1] && grid[r][c+1] == 1){vis[r][c+1] = true; q1.add(new Pair(r,c+1));}
        }
        
        int[] r = {-1,1,0,0}, c = {0,0,-1,1}; int step = 0;
        
        while(!q2.isEmpty()){
            int size = q2.size();
            for(int i=0;i<size;i++){
                Pair temp = q2.remove();
                
                for(int j=0;j<4;j++){
                    int tr = temp.row+r[j], tc = temp.col+c[j];
                    
                    if(tr>=0 && tc>=0 && tr<n && tc<n && !vis[tr][tc]){
                        if(grid[tr][tc] == 1) return step;
                        vis[tr][tc] = true;
                        q2.add(new Pair(tr,tc));
                    }
                }
            }
            step++;
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