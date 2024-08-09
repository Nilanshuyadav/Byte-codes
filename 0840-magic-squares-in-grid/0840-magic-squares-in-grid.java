class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int cnt=0;
        
        for(int r=0; r<row-2; r++){
            for(int c=0; c<col-2; c++){
                if(valid(grid, r, c)){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public boolean valid(int[][] grid, int ro, int co){
        int r1 = ro, r2 = ro+2, c1 = co, c2 = co+2;
        int[] row = new int[3], col = new int[3];
        Set<Integer> set = new HashSet<>();
        
        for(int r=r1; r<=r2; r++){
            for(int c=c1; c<=c2; c++){
                row[r-r1] += grid[r][c];
                col[c-c1] += grid[r][c];
                
                if(grid[r][c]==0 || grid[r][c]>9 || !set.add(grid[r][c])) return false;
            }
        }
        
        int sum = grid[r1][c1] + grid[r1+1][c1+1] + grid[r1+2][c1+2];
        
        for(int i=0; i<3; i++){
            if(row[i]!=sum || col[i]!=sum) return false;    
        }
        
        return sum == grid[r1][c2] + grid[r1+1][c2-1] + grid[r1+2][c2-2];
    }
}