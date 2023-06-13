class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int r=0, c=col-1;
        
        int result=0;
        
        while(r<row){
            if(grid[r][c] < 0){
                c--;
                
                if(c==-1){
                    result += (row-r) * (col-c-1);
                    break;
                }
            }    
            else{
                result += col-c-1;
                r++;
            }
        }
        
        return result;
    }
}