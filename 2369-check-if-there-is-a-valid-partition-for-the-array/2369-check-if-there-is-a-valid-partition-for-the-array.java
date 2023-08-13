class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        Boolean[] vis = new Boolean[n];
        
        return solve(0, nums, n, vis);
    }
    
    public boolean solve(int ind, int[] nums, int n, Boolean[] vis){
        if(ind == n){
            return true;
        }
        
        if(vis[ind]!=null){
            return vis[ind];
        }
        
        boolean ans=false;
        
        if(ind<n-1){
            if(nums[ind]==nums[ind+1]){
                ans |= solve(ind+2, nums, n, vis);    
            }
            
            if(ind<n-2){
                if(nums[ind]==nums[ind+1] && nums[ind+1]==nums[ind+2]){
                    ans |= solve(ind+3, nums, n, vis);    
                }
                
                if(nums[ind]==nums[ind+1]-1 && nums[ind]==nums[ind+2]-2){
                    ans |= solve(ind+3, nums, n, vis);
                }
            }    
        }
        
        
        return vis[ind] = ans;
    }
}