class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb;
        int n = grid.length;
        
        for(int r=0; r<n; r++){
            sb = new StringBuilder("");
            
            for(int c=0; c<n; c++){
                sb.append(grid[r][c]+",");    
            }
            
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        
        int ans=0;
        for(int c=0; c<n; c++){
            sb = new StringBuilder("");
            
            for(int r=0; r<n; r++){
                sb.append(grid[r][c]+",");
            }
            
            ans += map.getOrDefault(sb.toString(), 0);
        }
        
        return ans;
    }
}