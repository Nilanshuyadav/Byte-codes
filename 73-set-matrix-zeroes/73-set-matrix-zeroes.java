class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        List<Pair> lst = new ArrayList<Pair>();
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 0){
                    lst.add(new Pair<Integer,Integer>(i,j));
                }
            }
        }
        
        int n = lst.size();
        
        for(int i=0;i<n;i++){
            Pair<Integer,Integer> p = lst.get(i);
            setzero(p.getKey(),p.getValue(),matrix,r,c);
        }
    }
    
    private void setzero(int i,int j,int[][] matri, int r, int c){
        int curri = i;
        int currj = j;
        
        while(curri >=0){
            matri[curri][j] = 0;
            curri--;
        }
        
        curri = i;
        
        while(curri<r){
            matri[curri][j] = 0;
            curri++;
        }
        
        while(currj>=0){
            matri[i][currj] = 0;
            currj--;
        }
        
        currj = j;
        
        while(currj<c){
            matri[i][currj] = 0;
            currj++;
        }
    }
}