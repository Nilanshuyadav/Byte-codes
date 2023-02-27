class Solution {
    public void rotate(int[][] matrix) {
        int row=matrix.length, col=matrix[0].length;
        
        int r1=0, r2=row-1, temp;
        
        while(r1<r2){
            for(int ind=0; ind<col; ind++){
                temp = matrix[r1][ind];
                matrix[r1][ind] = matrix[r2][ind];
                matrix[r2][ind] = temp;
            }
            
            r1++;
            r2--;
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<=i; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}