class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, nums, nums.length, 0, target);
    }
    
    public int solve(int ind, int nums[], int n, int sum, int target){
        if(ind == n){
            return sum==target? 1 : 0;
        }
        
        return solve(ind+1, nums, n, sum+nums[ind], target)+solve(ind+1, nums, n, sum-nums[ind], target);
    }
}