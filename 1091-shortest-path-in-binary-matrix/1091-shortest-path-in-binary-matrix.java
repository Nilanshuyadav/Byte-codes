class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if(grid[0][0]!=0) return -1;
        int[][] dis = new int[row][col];
        int[] r = {-1,-1,0,1,1,1,0,-1}, c={0,1,1,1,0,-1,-1,-1};
        for(int[] i : dis)
            Arrays.fill(i,-1);
        dis[0][0] = 1;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair temp = q.remove();
                for(int i=0;i<8;i++){
                    int new_row = temp.row+r[i];
                    int new_col = temp.col+c[i];
                    
                    if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || grid[new_row][new_col]!=0 || dis[new_row][new_col]!=-1)continue;
                    
                    dis[new_row][new_col] = dis[temp.row][temp.col]+1;
                    q.add(new Pair(new_row,new_col));
                }
                
            }
        }
        
        return dis[row-1][col-1];
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