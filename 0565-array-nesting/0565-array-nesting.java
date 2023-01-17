class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        
        boolean[] vis = new boolean[n];
        int max = 0, start=0, cnt=0;
        
        for(int ind=0; ind<n; ind++){
            if(!vis[ind]){
                vis[ind] = true;
                start = nums[ind];
                cnt=1;
                
                while(!vis[start]){
                    cnt++;
                    vis[start] = true;
                    start = nums[start];
                }
                
                max = Math.max(max, cnt);
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