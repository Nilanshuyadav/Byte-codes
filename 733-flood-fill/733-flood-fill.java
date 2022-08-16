class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int mrow = image.length,mcol = image[0].length;
        
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        int present_value = image[sr][sc];
        int[] r = {-1,1,0,0},c = {0,0,-1,1};
        
        if(image[sr][sc] == color) return image;
        
        q.add(new Pair(sr,sc));
        
        while(!q.isEmpty()){
            Pair<Integer,Integer> temp = q.remove();
            image[temp.getKey()][temp.getValue()] = color;
            
            for(int i=0;i<4;i++){
                int row = temp.getKey()+r[i];
                int col = temp.getValue() + c[i];
                
                if(row>=0 && row<mrow && col>=0 && col<mcol && image[row][col] == present_value)
                    q.add(new Pair(row,col));
            }
        }
        
        return image;
    }
}