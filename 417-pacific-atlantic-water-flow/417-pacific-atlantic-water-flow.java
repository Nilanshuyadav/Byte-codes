class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        boolean[][] pac = new boolean[row][col], atl = new boolean[row][col];
        int[] r = {-1,0,1,0}, c ={0,1,0,-1};
        Queue<Pair> q = new LinkedList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<col;i++){
            pac[0][i] = true;
            q.add(new Pair(0,i));
        }
        for(int i=1;i<row;i++){
            pac[i][0] = true;
            q.add(new Pair(i,0));
        }
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            for(int i=0;i<4;i++){
                int new_row = temp.row+r[i];
                int new_col = temp.col+c[i];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || heights[new_row][new_col]<heights[temp.row][temp.col] || pac[new_row][new_col]) continue;
                
                pac[new_row][new_col] = true;
                q.add(new Pair(new_row,new_col));
            }
        }
        
        for(int i=0;i<col;i++){
            atl[row-1][i] = true;
            q.add(new Pair(row-1,i));
        }
        for(int i=0;i<row;i++){
            atl[i][col-1] = true;
            q.add(new Pair(i,col-1));
        }
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            for(int i=0;i<4;i++){
                int new_row = temp.row+r[i];
                int new_col = temp.col+c[i];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || heights[new_row][new_col]<heights[temp.row][temp.col] || atl[new_row][new_col]) continue;
                
                atl[new_row][new_col] = true;
                q.add(new Pair(new_row, new_col));
            }
        }
        
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(pac[i][j] && atl[i][j]){
                    List<Integer> al = new ArrayList<>();
                    al.add(i);
                    al.add(j);
                    ans.add(al);
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