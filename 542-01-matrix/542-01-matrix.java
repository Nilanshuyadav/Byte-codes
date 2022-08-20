class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int ans[][] = new int[row][col];
        
        int[] r = {-1,0,1,0}, c = {0,1,0,-1};
        
        for(int[] i : ans)
            Arrays.fill(i,Integer.MAX_VALUE);
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    q.add(new Pair(i,j));
                }    
            }
        }
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            for(int i=0;i<4;i++){
                int new_row = temp.row+r[i];
                int new_col = temp.col+c[i];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || ans[new_row][new_col] != Integer.MAX_VALUE) continue;
                
                ans[new_row][new_col] = 1+ans[temp.row][temp.col];
                q.add(new Pair(new_row,new_col));
            }
        }
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