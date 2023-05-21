class Solution {
    int[] r_arr={-1,0,1,0}, c_arr={0,1,0,-1};
    
    public int shortestBridge(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == 1){
                    grid[r][c] = 2;
                    makeTwo(r, c, row, col, grid, q);
                    
                    c=col;
                    r=row;
                }
            }
        }

        int r, c, temp[], new_r, new_c, size, cnt=0;
        
        while(!q.isEmpty()){
            size = q.size();
            cnt++;
            
            while(size-->0){
                temp = q.remove();
                
                r = temp[0];
                c = temp[1];
                
                for(int ind=0; ind<4; ind++){
                    new_r = r+r_arr[ind];
                    new_c = c+c_arr[ind];
                    
                    if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || grid[new_r][new_c]==2)
                            continue;
                    
                    if(grid[new_r][new_c] == 1){
                        return cnt-1;
                    }
                    else{
                        grid[new_r][new_c] = 2;
                        q.add(new int[]{new_r, new_c});
                    }
                }
            }
        }
        
        return -1;
    }
    
    public void makeTwo(int r, int c, int row, int col, int[][] grid, Queue<int[]> q){
        q.add(new int[]{r,c});
        
        int new_r, new_c;
        
        for(int ind=0; ind<4; ind++){
            new_r = r+r_arr[ind];
            new_c = c+c_arr[ind];
            
            if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || grid[new_r][new_c]!=1)
                continue;
            
            grid[new_r][new_c] = 2;
            makeTwo(new_r, new_c, row, col, grid, q);
        }
    }
}