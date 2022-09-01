class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length, col = image[0].length;
        int[] r = {-1,0,1,0}, c={0,1,0,-1};
        
        if(image[sr][sc] == color) return image;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        
        boolean[][] vis = new boolean[row][col];
        vis[sr][sc] = true;
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            int present_value = image[temp.row][temp.col];
            image[temp.row][temp.col] = color;
            
            for(int i=0;i<4;i++){
                int new_row = temp.row+r[i];
                int new_col = temp.col+c[i];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || image[new_row][new_col]!=present_value || vis[new_row][new_col]) continue;
                vis[new_row][new_col] = true;
                q.add(new Pair(new_row,new_col));
            }
        }
        return image;
    }
}

class Pair{
    int row;
    int col;
    
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}