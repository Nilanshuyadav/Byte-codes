class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        
        int r=0, c=col-1;
        
        while(r<row && 0<=c){
            if(r>0 && mat[r][c]<mat[r-1][c]){
                r--;
                continue;
            }
            else if(r<row-1 && mat[r][c]<mat[r+1][c]){
                r++;
                continue;
            }
            else if(c>0 && mat[r][c]<mat[r][c-1]){
                c--;
                continue;
            }
            else if(c<col-1 && mat[r][c]<mat[r][c+1]){
                c++;
                continue;
            }
            
            return new int[]{r, c};
        }
        
        return new int[]{-1, -1};
    }
}