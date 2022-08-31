class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        int row = height.length,col = height[0].length;
        int[][] vis = new int[row][col];
        List<List<Integer>> ans = new ArrayList<>();
        int[] r = {-1,0,1,0}, c={0,1,0,-1};
        
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<col;i++){
            vis[0][i] = 1;
            q.add(new Pair(0,i));
        }
        for(int i=1;i<row;i++){
            vis[i][0] = 1;
            q.add(new Pair(i,0));
        }
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            for(int i=0;i<4;i++){
                int new_row = temp.row+r[i];
                int new_col = temp.col+c[i];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || 
                   vis[new_row][new_col]==1 || 
                   height[new_row][new_col]<height[temp.row][temp.col]) continue;
                
                vis[new_row][new_col] = 1;
                q.add(new Pair(new_row,new_col));
            }
        }
        
        for(int i=0;i<row;i++){
            if(vis[i][col-1] == 1){
                List<Integer> al = new ArrayList<>();
                al.add(i);
                al.add(col-1);
                ans.add(al);
            }
            vis[i][col-1] = 2;
            q.add(new Pair(i,col-1));
        }
        
        for(int i=0;i<col;i++){
            if(vis[row-1][i] == 1){
                List<Integer> al = new ArrayList<>();
                al.add(row-1);
                al.add(i);
                ans.add(al);
            }
            vis[row-1][i] = 2;
            q.add(new Pair(row-1,i));
        }
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            for(int i=0;i<4;i++){
                int new_row = temp.row+r[i];
                int new_col = temp.col+c[i];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || vis[new_row][new_col]==2 || height[new_row][new_col]<height[temp.row][temp.col]) continue;
                
                if(vis[new_row][new_col] == 1) ans.add(new ArrayList<>(){{add(new_row); add(new_col);}});
                vis[new_row][new_col] = 2;
                q.add(new Pair(new_row,new_col));
            }
        }
        
        return ans;
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