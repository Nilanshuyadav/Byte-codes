class Solution {
    int[] r_arr = {-1, 0, 1, 0},
                c_arr = {0, 1, 0, -1};
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int row = grid.size(), col = grid.get(0).size();
        
        int[][] dis = new int[row][col];
        Queue<int[]> q = new LinkedList<>();
        
        for(int r=0; r<row; r++){
            Arrays.fill(dis[r], (int)1e8);
        }
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid.get(r).get(c) == 1){
                    q.add(new int[]{r,c});
                    dis[r][c] = 0;
                }
            }
        }
        
        int[] temp;
        int r, c, new_r, new_c;
        
        while(!q.isEmpty()){
            temp = q.remove();
            
            r = temp[0];
            c = temp[1];
            
            for(int i=0; i<4; i++){
                new_r = r + r_arr[i];
                new_c = c + c_arr[i];
                
                if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || dis[new_r][new_c]<=(dis[r][c]+1)) continue;
                
                dis[new_r][new_c] = dis[r][c]+1;
                q.add(new int[]{new_r, new_c});
            }    
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2]-a[2]);
        
        pq.add(new int[]{row-1, col-1, dis[row-1][col-1]});
        
        int d;
        
        while(!pq.isEmpty()){
            temp = pq.remove();
            
            r = temp[0];
            c = temp[1];
            d = temp[2];
            
            if(r==0 && c==0) return d;
            
            for(int i=0; i<4; i++){
                new_r = r + r_arr[i];
                new_c = c + c_arr[i];

                if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || dis[new_r][new_c]==-1) continue;

                pq.add(new int[]{new_r, new_c, Math.min(dis[new_r][new_c], d)});
                dis[new_r][new_c] = -1;
            }
        }
        
        return -1;
    }
}