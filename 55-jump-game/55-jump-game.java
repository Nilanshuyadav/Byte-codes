class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new Boolean[n];
        
        
        return function(nums,0,nums.length);
    }
    
    public boolean function(int[] nums, int ind,int n){
        if(ind == n-1) return dp[ind] = true;
        if(dp[ind] != null) {return dp[ind];}
        
        boolean temp = false;
        
        for(int i=1;i<=nums[ind];i++){
            if(ind+i >= n || i==0) break;
            temp = temp || function(nums,ind+i,n);
        }    
        
        dp[ind] = temp;
        return temp;
    }
}