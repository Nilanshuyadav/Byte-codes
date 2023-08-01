class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n = nums.length;
        
        for(int ind : nums){
            sum += ind;
        }
        
        Boolean[][] dp = new Boolean[n][(sum/2)+2];
        
        if((sum&1)!=0) return false;
        
        return solve(n-1, 0, nums, sum/2, dp);
    }
    
    public boolean solve(int ind, int sum, int[] nums, int target, Boolean[][] dp){
        if(ind == -1){
           return sum==target; 
        }
        
        if(dp[ind][sum] != null)   return dp[ind][sum];
        
        boolean temp = false;
        
        if(sum+nums[ind]<=target){
            temp |= solve(ind-1, sum+nums[ind], nums, target, dp);
        }
        
        temp |= solve(ind-1, sum, nums, target, dp);
        
        return dp[ind][sum] = temp;
    }
}