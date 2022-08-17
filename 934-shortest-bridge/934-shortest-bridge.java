class Solution { 
    int[] r = {-1,1,0,0}, c = {0,0,-1,1};
    Queue<Pair> q;
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        
        
        boolean[][] vis = new boolean[n][n];
        
        q = new LinkedList<>();
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    
                    function(grid,i,j,n,vis);
                    i = n; j = n;
                }
            }
            
        }
        
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(grid[i][j] == 1){
        //             vis[i][j] = true;
        //             q.add(new int[]{i,j});
        //         }
        //     }
        // }
        
//         while(!q.isEmpty()){
//             Pair temp = q.remove();
            
//             int row = temp.row;
//             int col = temp.col;
            
//             q2.add(new Pair(row,col));
            
//             vis[row][col] = true;
//             grid[row][col] = 0;
            
//             if(row-1 >=0 && vis[row-1][col]!=true && grid[row-1][col] == 1)
//                 q.add(new Pair(row-1,col));
//             if(row+1 <n && vis[row+1][col]!=true && grid[row+1][col] == 1)
//                 q.add(new Pair(row+1,col));
//             if(col-1 >=0 && vis[row][col-1]!=true && grid[row][col-1] == 1)
//                 q.add(new Pair(row,col-1));
//             if(col+1 <n && vis[row][col+1]!=true && grid[row][col+1] == 1)
//                 q.add(new Pair(row,col+1));
//         }
        
        
        int dis = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                
                Pair temp = q.remove();
                
                for(int i=0;i<4;i++){
                    int tr = temp.row + r[i], tc = temp.col +
                        c[i];
                    
                    if(tr >= 0 && tc >= 0
                      && tr < n && tc < n
                      && vis[tr][tc] != true){
                        if(grid[tr][tc] == 1)
                            return dis;
                        vis[tr][tc] = true;
                        q.add(new Pair(tr,tc));
                    }
                }
            }
            dis++;
        }
        
        return dis;
    }
    
    public void function(int[][] grid, int row,int col,int n,boolean vis[][]){

        grid[row][col] = 0;
        q.add(new Pair(row,col));
        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int tr = row+r[i], tc = col+c[i];
            
            if(tr >= 0 && tc >= 0
              && tr < n && tc < n
              && grid[tr][tc] == 1)
                function(grid,tr,tc,n,vis);
        }
    }
}

class Pair{
    int row;
    int col;
    
    public Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}