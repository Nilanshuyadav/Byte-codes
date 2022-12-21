class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        
        Arrays.fill(dp, -1);
        
        return dfs(n-1, nums, n, target, dp);
    }
    
    public int dfs(int ind, int[] nums, int n, int target, int[] dp){
        
        if(target==0)
            return 1;
        
        if(dp[target] != -1)
            return dp[target];
        
        int temp = 0;
        
        for(int inx=0; inx<n; inx++){
            if(nums[inx]<=target)
                temp += dfs(inx, nums, n, target-nums[inx], dp);
        }
        
        return dp[target]=temp;
    }
}