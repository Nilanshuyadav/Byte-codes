class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        
        int l=0, h=(row*col)-1, m, num;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            num = findNum(matrix, col, m);
            
            if(num == target) return true;
            else if(num < target) l = m+1;
            else h = m-1;
        }
        
        return false;
    }
    
    public int findNum(int[][] matrix, int col, int m){
        int r = m/col, c = m%col;
        
        return matrix[r][c];
    }
}