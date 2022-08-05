class Solution {
    Pair[][] grid;
    
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        int row = height.length, col = height[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        
        grid = new Pair[row][col];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] != null && grid[i][j].pacific == true && grid[i][j].atlantic == true)
                    ans.add(new ArrayList(Arrays.asList(i,j)));
                else{
                    if(function(height,i,j))
                        ans.add(new ArrayList(Arrays.asList(i,j)));
                }
            }
            
        }
        
        return ans;
    }
    
    public boolean function(int[][] height,int row,int col){
        return pacific(height,row,col) && atlantic(height,row,col);
    }
    
    public boolean pacific(int[][] height, int row, int col){
        if(row == 0 || col == 0) return true;
        
        boolean pacific = false;
        int present_value = height[row][col];
        height[row][col] = -1;
        
        if(row-1 >=0 && height[row-1][col] != -1 && height[row-1][col] <= present_value)
            pacific = pacific || pacific(height,row-1,col);
        
        if(row+1 <height.length && height[row+1][col] != -1 && height[row+1][col] <= present_value)
            pacific = pacific || pacific(height,row+1,col);
        
        if(col-1 >=0 && height[row][col-1] != -1 && height[row][col-1] <= present_value)
            pacific = pacific || pacific(height,row,col-1);
        
        if(col+1 <height[0].length && height[row][col+1] != -1 && height[row][col+1] <= present_value)
            pacific = pacific || pacific(height,row,col+1);
        
        height[row][col] = present_value;
        
        if(grid[row][col] == null){
            grid[row][col] = new Pair(true,pacific,false);
        }
        else{
            grid[row][col].visited = true;
            grid[row][col].pacific = pacific;
        }
        
//         grid[row][col].visited = true;
//         grid[row][col].pacific = pacific;
        
        return pacific;
    }
    
    
    
    public boolean atlantic(int[][] height, int row, int col){
        if(row == height.length-1 || col == height[0].length-1) return true;
        
        boolean atlantic = false;
        int present_value = height[row][col];
        height[row][col] = -1;
        
        if(row-1 >=0 && height[row-1][col] != -1 && height[row-1][col] <= present_value)
            atlantic = atlantic || atlantic(height,row-1,col);
        
        if(row+1 <height.length && height[row+1][col] != -1 && height[row+1][col] <= present_value)
            atlantic = atlantic || atlantic(height,row+1,col);
        
        if(col-1 >=0 && height[row][col-1] != -1 && height[row][col-1] <= present_value)
            atlantic = atlantic || atlantic(height,row,col-1);
        
        if(col+1 <height[0].length && height[row][col+1] != -1 && height[row][col+1] <= present_value)
            atlantic = atlantic || atlantic(height,row,col+1);
        
        height[row][col] = present_value;
        
        if(grid[row][col] == null){
            grid[row][col] = new Pair(true,false,atlantic);
        }
        else{
            grid[row][col].visited = true;
            grid[row][col].atlantic = atlantic;
        }
        
        return atlantic;
    }
}



class Pair{
    boolean visited = false,atlantic = false,pacific = false;
    
    public Pair(boolean visited, boolean pacific,boolean atlantic){
        this.visited = visited;
        this.pacific = pacific;
        this.atlantic = atlantic;
    }
}