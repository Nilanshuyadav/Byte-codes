class Solution {
    public int maxDistance(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] r = {-1,0,1,0}, c = {0,1,0,-1};
        int[][] dis = new int[row][col];
        for(int i[] : dis)
            Arrays.fill(i,-1);
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(grid[i][j] == 1){
                    dis[i][j] = 0;
                    q.add(new Pair(i,j));
                }    
        int size1 = q.size();
        if(size1==(row*col) || size1==0) return -1;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair temp = q.remove();
                for(int i=0;i<4;i++){
                    int new_row = temp.row+r[i];
                    int new_col = temp.col+c[i];
                    
                    if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || dis[new_row][new_col]!=-1) continue;
                    
                    dis[new_row][new_col] = dis[temp.row][temp.col]+1;
                    q.add(new Pair(new_row,new_col));
                }
            }
        }
        
        int max = 0;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                max = Math.max(max,dis[i][j]);
        
        return max;
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