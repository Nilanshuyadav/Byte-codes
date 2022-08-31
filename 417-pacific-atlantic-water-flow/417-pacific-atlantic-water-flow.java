class Solution {
    int[] r = {-1,0,1,0},c = {0,1,0,-1};
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        int row = height.length,col = height[0].length;      
        boolean[][] alt = new boolean[row][col];
        boolean[][] pac = new boolean[row][col];
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<row;i++){
            pac[i][0] = true;
            dfs(pac,i,0,height);
            alt[i][col-1] = true;
            dfs(alt,i,col-1,height);
        }
        
        for(int i=0;i<col;i++){
            pac[0][i] = true;
            dfs(pac,0,i,height);
            alt[row-1][i] = true;
            dfs(alt,row-1,i,height);
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pac[i][j] && alt[i][j]){
                    List<Integer> al = new ArrayList<>();
                    al.add(i);
                    al.add(j);
                    ans.add(al);
                }
            }
        }
        
        return ans;
    }
    
    public void dfs(boolean[][] arr, int row, int col, int[][] height){
        
        for(int i=0;i<4;i++){
            int new_row = row+r[i];
            int new_col = col+c[i];
            
            if(new_row<0 || new_col<0 || new_row>=height.length || new_col>=height[0].length || arr[new_row][new_col] || height[row][col]>height[new_row][new_col ]) continue;
            arr[new_row][new_col] = true;
            dfs(arr,new_row,new_col,height);
        }
    }
}

