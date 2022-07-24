class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        
        int i=0,j=col-1;
        
        while(i < row && j>=0){
            if(matrix[i][j] < target)i++;
            else if(matrix[i][j] > target)j--;
            else return true;
        }
        
        return false;
    }
}