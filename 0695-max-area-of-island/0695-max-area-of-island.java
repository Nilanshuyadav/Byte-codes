class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0, area=0;
        
        int row = grid.length, col = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int[] r_arr = {-1,0,1,0}, c_arr={0,1,0,-1};
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == 1){
                    grid[r][c] = 0;
                    q.add(new int[]{r,c});
                    
                    while(!q.isEmpty()){
                        int[] temp = q.remove();
                        
                        for(int ind=0; ind<4; ind++){
                            int new_row = temp[0]+r_arr[ind];
                            int new_col = temp[1]+c_arr[ind];
                            
                            if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || grid[new_row][new_col]==0) continue;
                            area++;
                            grid[new_row][new_col] = 0;
                            q.add(new int[]{new_row, new_col});
                        }
                    }
                    
                    max_area = Math.max(max_area, area+1);
                    area = 0;
                }
            }
        }
        
        return max_area;
    }
}