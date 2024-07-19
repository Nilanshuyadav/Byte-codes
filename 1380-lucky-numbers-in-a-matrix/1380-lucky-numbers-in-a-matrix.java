class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        Set<Integer> set = new HashSet<>();
        int min, max;
        List<Integer> ans = new ArrayList<>();
        
        for(int r=0; r<row; r++){
            min = (int)1e8;
            
            for(int c=0; c<col; c++){
                min = Math.min(min, matrix[r][c]);            
            }
            
            set.add(min);
        }
        
        for(int c=0; c<col; c++){
            max = 0;
            
            for(int r=0; r<row; r++){
                max = Math.max(max, matrix[r][c]);    
            }
            
            if(!set.add(max)){
                ans.add(max);
            }
        }
        
        return ans;
    }
}