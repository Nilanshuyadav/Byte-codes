class Solution {
    public int maxDistance(int[][] grid) {
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        int n = grid.length;
        
        for(int i =0;i<n;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j] == 1)
                    q.add(new Pair(i,j));
        
        if(q.size() == n*n) return -1;
        
        int[] r = new int[]{-1,1,0,0} , c = new int[]{0,0,-1,1};
        
        int k =0;
        while(!q.isEmpty()){
            int size = q.size();
            
            k++;
            
            while(size-- > 0){
                
                Pair<Integer,Integer> temp = q.remove();
                
                for(int i = 0;i<4;i++){
                    int row = temp.getKey()+r[i],col = temp.getValue()+c[i];
                    
                    if(row >= 0 && row < n
                      && col >= 0 && col < n
                      && grid[row][col] == 0){
                        q.add(new Pair(row,col));
                        grid[row][col] = 1;
                    }    
                }
                   
                    
            }
        }
        
        return --k;
    }
}