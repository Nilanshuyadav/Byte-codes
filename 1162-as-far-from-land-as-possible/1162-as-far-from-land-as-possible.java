class Solution {
    public int maxDistance(int[][] grid) {
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        int n = grid.length;
        
        for(int i =0;i<n;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j] == 1)
                    q.add(new Pair(i,j));
        
        if(q.size()/n == n) return -1;
        
        int[] r = new int[]{-1,1,0,0} , c = new int[]{0,0,-1,1};
        
        int k =0;
        while(!q.isEmpty()){
            int size = q.size();
            
            k++;
            
            while(size-- > 0){
                
                Pair<Integer,Integer> temp = q.remove();
                
                for(int i = 0;i<4;i++){
                    int row = temp.getKey(),col = temp.getValue();
                    
                    if(row+r[i] >= 0 && row+r[i] < n
                      && col+c[i] >= 0 && col+c[i] < n
                      && grid[row+r[i]][col+c[i]] == 0){
                        q.add(new Pair(row+r[i],col+c[i]));
                        grid[row+r[i]][col+c[i]] = 1;
                    }    
                }
                   
                    
            }
        }
        
        return --k;
    }
}