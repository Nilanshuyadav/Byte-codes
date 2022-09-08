class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] r = {-1,0,1,0}, c={0,1,0,-1};
        int[][] dis = new int[row][col];
        for(int[] i : dis) Arrays.fill(i,Integer.MAX_VALUE);
        
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(mat[i][j] == 0){
                    dis[i][j] = 0;
                    q.add(new Pair(i,j));
                }
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            for(int i=0;i<4;i++){
                int new_row = temp.row+r[i];
                int new_col = temp.col+c[i];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || mat[new_row][new_col]==0) continue;
                
                if(dis[new_row][new_col]>dis[temp.row][temp.col]+1){
                    dis[new_row][new_col] = dis[temp.row][temp.col]+1;
                    q.add(new Pair(new_row,new_col));
                }
            }
        }
        
        return dis;
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