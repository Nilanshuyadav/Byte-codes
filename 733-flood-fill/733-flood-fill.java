class Solution {
    int present_value;
    int[] r = {-1,0,1,0}, c={0,1,0,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length, col = image[0].length;
        
        if(image[sr][sc] == color) return image;
        
        present_value = image[sr][sc];
        dfs(image, sr,sc,color);
        
        return image;
    }
    
    public void dfs(int[][] image, int row, int col, int color){
        image[row][col] = color;
        for(int i=0;i<4;i++){
            int new_row = row+r[i];
            int new_col = col+c[i];
            
            if(new_row<0 || new_col<0 || new_row>=image.length || new_col>=image[0].length || image[new_row][new_col]!=present_value) continue;
            dfs(image,new_row,new_col,color);
        }
    }
}