class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length,col = image[0].length;
        if(image[sr][sc] == color) return image;
        function(image,sr,sc,color,row,col,image[sr][sc]);
        
        return image;
    }
    
    public void function(int[][] image, int sr, int sc, int color, int row, int col,int present_value){
        image[sr][sc] = color;
        
        if(sr+1<row && image[sr+1][sc]==present_value)
            function(image,sr+1,sc,color,row,col,present_value);
        if(sr-1>=0 && image[sr-1][sc]==present_value)
            function(image,sr-1,sc,color,row,col,present_value);
        if(sc-1>=0 && image[sr][sc-1]==present_value)
            function(image,sr,sc-1,color,row,col,present_value);
        if(sc+1<col && image[sr][sc+1]==present_value)
            function(image,sr,sc+1,color,row,col,present_value);
    }
}