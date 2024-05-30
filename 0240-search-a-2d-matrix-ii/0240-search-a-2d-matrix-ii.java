class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col=matrix[0].length,
            r=0, c=col-1;
        
        while(r<row && 0<=c){
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] < target) r++;
            else c--;
        }
        
        return false;
    }
}