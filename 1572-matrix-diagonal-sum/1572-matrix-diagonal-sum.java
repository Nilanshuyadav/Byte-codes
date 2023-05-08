class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length, i=0, j=n-1;
        int sum = 0;
        
        while(i<n){
            sum += mat[i][i];
            sum += mat[i++][j--];
        }
        
        return ((n&1) != 0) ? sum-mat[n/2][n/2] : sum;
    }
}