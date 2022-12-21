class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        
        for(int ind[] : dp)
            Arrays.fill(ind, -1);
        
        return dfs(n-1, nums, n, target, dp);
    }
    
    public int dfs(int ind, int[] nums, int n, int target, int[][] dp){
        
        if(dp[ind][target] != -1)
            return dp[ind][target];
        
        int temp = 0;
        
        for(int inx=0; inx<n; inx++){
            if(nums[inx]<=target)
                temp += dfs(inx, nums, n, target-nums[inx], dp);
        }
        
        return dp[ind][target]=target==0?1:temp;
    }
}