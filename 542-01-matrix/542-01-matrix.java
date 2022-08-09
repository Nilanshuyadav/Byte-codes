class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length,col = mat[0].length;
        int ans[][] = new int[row][col];
        
        for(int i[] : ans)
            Arrays.fill(i,Integer.MAX_VALUE);
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    q.add(new Pair(i,j));
                }
        }
        
        int[] r = {-1,1,0,0}, c = {0,0,-1,1};
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
                
                for(int i=0;i<4;i++){
                    int tr = temp.r + r[i];
                    int tc = temp.c + c[i];
                    
                    if(tr >= 0 && tr<row && tc >=0 && tc<col &&                          ans[tr][tc] == Integer.MAX_VALUE){
                        ans[tr][tc] = 1 + ans[temp.r][temp.c];
                        q.add(new Pair(tr,tc));
                    }
                }
        }
        
        return ans;
    }
}

class Pair{
    int r;
    int c;
    
    public Pair(int r,int c){
        this.r = r;
        this.c = c;
    }
}