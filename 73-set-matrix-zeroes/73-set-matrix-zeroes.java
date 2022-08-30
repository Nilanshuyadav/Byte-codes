class Solution {
    public void setZeroes(int[][] m) {
        Queue<Pair> q = new LinkedList<>();
        
        int row = m.length;
        int col = m[0].length;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                if(m[i][j] == 0) q.add(new Pair(i,j));
        }
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            int r = temp.row,c = temp.col;
            
            while(--r>=0)
                m[r][c] = 0;
            r = temp.row;
            while(++r<row)
                m[r][c] = 0;
            r=temp.row;
            while(--c>=0)
                m[r][c] = 0;
            c = temp.col;
            while(++c<col)
                m[r][c] = 0;
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