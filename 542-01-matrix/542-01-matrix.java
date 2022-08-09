class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length,col = mat[0].length;
        int ans[][] = new int[row][col];
        
        for(int i[] : ans)
            Arrays.fill(i,Integer.MAX_VALUE);
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                if(mat[i][j] == 0)
                    q.add(new Pair(i,j,0));
        }
        
        int[] r = {-1,1,0,0}, c = {0,0,-1,1};
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            if(ans[temp.r][temp.c] > temp.dis){
                ans[temp.r][temp.c] = temp.dis;
                
                for(int i=0;i<4;i++){
                    int tr = temp.r + r[i];
                    int tc = temp.c + c[i];
                    
                    if(tr >= 0 && tr<row && tc >=0 && tc<col && ans[tr][tc] == Integer.MAX_VALUE)
                        q.add(new Pair(tr,tc,temp.dis+1));
                }
            }
        }
        
        return ans;
    }
}

class Pair{
    int r;
    int c;
    int dis;
    
    public Pair(int r,int c, int dis){
        this.r = r;
        this.c = c;
        this.dis = dis;
    }
}