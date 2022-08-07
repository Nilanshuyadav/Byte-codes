class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        int n = grid.length;
        
        if(n == 1 && grid[0][0] == 0) return 1;
        
        if(grid[0][0] == 0)
            q.add(new Pair(0,0));
        
        int k = 1;
        
        int[] r = new int[]{-1,-1,0,1,1,1,0,-1}, c = new int[]{0,1,1,1,0,-1,-1,-1};
        
        while(!q.isEmpty()){
            int size = q.size();
            
            k++;
            
            while(size-- > 0){
                Pair<Integer,Integer> temp = q.remove();
                
                for(int i=0;i<8;i++){
                    int row = temp.getKey() + r[i];
                    int col = temp.getValue() + c[i];
                    
                    if(row == n-1 && col == n-1 && grid[row][col] == 0) return k;
                    
                    if(row >= 0 && row < n
                      && col >= 0 && col < n
                      && grid[row][col] == 0){
                        q.add(new Pair(row,col));
                        grid[row][col] = 1;
                    }    
                }
                
            }
        }
        
        return -1;
    }
}