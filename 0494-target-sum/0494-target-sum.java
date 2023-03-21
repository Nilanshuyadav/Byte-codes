class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        
        return solve(0, nums, nums.length, 0, target, dp);
    }
    
    public int solve(int ind, int nums[], int n, int sum, int target, Map<String, Integer> dp){
        if(ind == n){
            return sum==target? 1 : 0;
        }
        
        String st = ""+ind+","+sum;
        
        if(dp.containsKey(st))
            return dp.get(st);
        
        dp.put(st, solve(ind+1, nums, n, sum+nums[ind], target, dp)+solve(ind+1, nums, n, sum-nums[ind], target, dp));
        
        return dp.get(st);
    }
}