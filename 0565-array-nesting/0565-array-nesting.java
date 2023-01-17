class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        
        boolean[] vis = new boolean[n];
        int max = 0;
        
        for(int ind=0; ind<n; ind++){
            if(!vis[ind]){
                vis[ind] = true;
                max = Math.max(max, 1+solve(ind, nums, vis));
            }
        }
        
        return max;
    }
    
    public int solve(int ind, int[] nums, boolean[] vis){
        if(!vis[nums[ind]]){
            vis[nums[ind]] = true;
            return 1+solve(nums[ind], nums, vis);
        }
        
        return 0;
    }
}