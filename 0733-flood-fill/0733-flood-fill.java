class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        
        int prev_color = image[sr][sc], row = image.length, col = image[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int[] temp;
        q.add(new int[]{sr, sc});
        
        image[sr][sc] = color;
        
        int r,c, new_r, new_c, r_arr[] = {-1, 0, 1, 0}, c_arr[]={0, 1, 0, -1};
        
        while(!q.isEmpty()){
            temp = q.remove();
            
            r = temp[0];
            c = temp[1];
            
            for(int ind=0; ind<4; ind++){
                new_r = r+r_arr[ind];
                new_c = c+c_arr[ind];
                
                if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || image[new_r][new_c]!=prev_color)
                    continue;
                
                image[new_r][new_c] = color;
                q.add(new int[]{new_r, new_c});
            }
        }
        
        return image;
    }
}