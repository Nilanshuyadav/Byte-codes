class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        int n = grid.length;
        
        for(int r=0; r<n; r++){
            StringBuilder sb = new StringBuilder("");
            
            for(int c=0; c<n; c++){
                sb.append(grid[r][c]+",");    
            }
            
            map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
        }
        
        int ans = 0;
        
        for(int c=0; c<n; c++){
            StringBuilder sb = new StringBuilder("");
            
            for(int r=0; r<n; r++){
                sb.append(grid[r][c]+",");
            }
            
            if(map.containsKey(sb.toString())){
                ans += (map.get(sb.toString()));
            }
        }
        
        return ans;
    }
}