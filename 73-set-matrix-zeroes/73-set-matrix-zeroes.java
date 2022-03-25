class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        List<Pair> al = new ArrayList<Pair>();
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
                if(matrix[i][j] == 0) al.add(new Pair<Integer,Integer>(i,j));
        }
        
        int n = al.size();
        
        for(int i=0;i<n;i++){
            Pair<Integer,Integer> p = al.get(i);
            setzero(p.getKey(),p.getValue(),matrix,c,r);
        }    
    }
    
    
    
    private void setzero(int i,int j,int[][] arr,int c,int r){
        int ti = i;
        int tj = j;
        
        while(tj>=0){
            arr[i][tj] = 0;
            tj--;
        }
        
        tj = j;
        
        while(tj<c){
            arr[i][tj] = 0;
            tj++;
        }
        
        while(ti>=0){
            arr[ti][j] = 0;
            ti--;
        }
        
        ti = i;
        
        while(ti<r){
            arr[ti][j] = 0;
            ti++;
        }
    }
}