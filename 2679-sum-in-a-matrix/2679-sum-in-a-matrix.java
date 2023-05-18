class Solution {
    public int matrixSum(int[][] nums) {
        int row = nums.length, col = nums[0].length;
        
        for(int ind[] : nums){
            Arrays.sort(ind);
        }
        
        int score=0, max=0;
        
        for(int c=col-1; c>=0; c--){
            max = 0;
            
            for(int r=0; r<row; r++){
                max = Math.max(max, nums[r][c]);
            }
            
            score += max;
        }
        
        return score;
    }
}