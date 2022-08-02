class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        function(image, sr, sc, color);
        return image;
    }
    
    public void function(int[][] image, int row, int col, int color){
        if(image[row][col] == color) return;
        int present_value = image[row][col];
        
        int duplicate_row = row, duplicate_col = col;
        int row_length = image.length, col_length = image[0].length;
        
        while(--row >= 0){
            if(image[row][col] == present_value){
                image[duplicate_row][duplicate_col] = -1;
                function(image,row,col,color);
            }
            else break;
        }
        
        row = duplicate_row;
        
        while(++row < row_length){
            if(image[row][col] == present_value){
                image[duplicate_row][duplicate_col] = -1;
                function(image,row,col,color);
            }    
            else break;
        }
        
        row = duplicate_row;
        
        while(--col >= 0){
            if(image[row][col] == present_value){
                image[duplicate_row][duplicate_col] = -1;
                function(image,row,col,color);
            }
            else break;
        }
        
        col = duplicate_col;
        
        while(++col < col_length){
            if(image[row][col] == present_value){
                image[duplicate_row][duplicate_col] =-1;
                function(image,row,col,color);
            }
            else break;
        }
        
        image[duplicate_row][duplicate_col] = color;
        
        return;
    }
}