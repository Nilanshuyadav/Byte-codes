class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int row = mat.length, col = mat[0].length;
        
        int[][] ans = new int[row][col];
        for(int ind[] : ans)
            Arrays.fill(ind, Integer.MAX_VALUE);
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(mat[r][c] == 0){
                    ans[r][c] = 0;
                    q.add(new int[]{r,c});
                }
            }
        }
        
        int new_r, new_c, r_arr[]={-1,0,1,0}, c_arr[]={0,1,0,-1};
        
        while(!q.isEmpty()){
            int[] temp = q.remove();
            
            for(int ind=0; ind<4; ind++){
                new_r = temp[0]+r_arr[ind];
                new_c = temp[1]+c_arr[ind];
                
                if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || mat[new_r][new_c]==0)
                    continue;
                
                if(1+ans[temp[0]][temp[1]]<ans[new_r][new_c]){
                    ans[new_r][new_c] = 1+ans[temp[0]][temp[1]];
                    
                    q.add(new int[]{new_r, new_c});
                }
            }
        }
        
        return ans;
    }
}